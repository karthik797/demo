package com.example.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.ApiController;
import com.example.model.Call;
import com.example.model.MeanStrickPriceRequest;
import com.example.model.Parameters;
import com.example.model.ParametersSnapshot;
import com.example.model.Put;
import com.example.repository.ParametersRepository;

@Service
public class ParametersService {

	 private static final Logger LOG = LoggerFactory.getLogger(ParametersService.class);

	@Autowired
	ParametersRepository parametersRepository;

	
	public ParametersSnapshot meanStrickPrice(String index,String expiryDate)
	{
		
		System.out.println("StrickPrice inputs:" + index +  expiryDate);
		Element table=null;
		Element table2=null;
		Parameters parameters=null;
		ParametersSnapshot parametersSnapshot=null;
		List<Parameters> parametersList=new ArrayList<>();
		
		try {
			String URL="https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?segmentLink=17&instrument=OPTIDX&symbol="
						+ index +"&date="+ expiryDate;
			Document doc = Jsoup.connect(URL).get();
			
			table = doc.select("table").get(2);
			table2=doc.select("table").get(0);
			
			Elements elements = table.select("tr");
			int row=1;
			String CALLSOI=null;
			String CALLSLTP=null;
			String PUTOI=null;
			String PUTLTP=null;
			String StrikePrice=null;
			String MeanStrikePrice=null;
			int StrikePriceAtRow=0;
			
			//System.out.println(table2.select("td").next().text());
			String snapSubHeading=table2.select("td").next().text();
			while(row<elements.size()-2)
			{
			//	System.out.println("Childs= "+ elements.get(row).children().size());
			//	System.out.println("row="+row);
				
				if(!elements.get(row).child(2).select("td[class=ylwbg]").text().isEmpty())
				{
					
					CALLSOI=elements.get(row).child(2).select("td[class=ylwbg]").text();
					StrikePrice=elements.get(row).child(11).select("td[class=grybg]").text();
					StrikePriceAtRow=row;
					MeanStrikePrice=StrikePrice;
					//System.out.println("chngInOI:=" + chngInOI  +"\n"+ "LTP:=" + LTP);
					
				}
				if(!elements.get(row).child(5).select("td[class=ylwbg]").text().isEmpty())
				{
					CALLSLTP=elements.get(row).child(5).select("td[class=ylwbg]").text();
				}
				
				//-----------------------
				
				if(  !elements.get(row).child(17).select("td[class=nobg]").text().isEmpty())
				{
				
					PUTLTP=elements.get(row).child(17).select("td[class=nobg]").text();
					
				}
				if(  !elements.get(row).child(20).select("td[class=nobg]").text().isEmpty())
				{
					PUTOI=elements.get(row).child(20).select("td[class=nobg]").text();
				}	
				
				row++;
			}
			
			
			//System.out.println("StrickePriceAt= "+ StrikePriceAtRow);
			for(int i=StrikePriceAtRow-7;i<=StrikePriceAtRow+7;i++)
			{
				
				row=i;
				CALLSOI=elements.get(row).child(2).text();
				StrikePrice=elements.get(row).child(11).text();
				CALLSLTP=elements.get(row).child(5).text();
				PUTLTP=elements.get(row).child(17).text();
				PUTOI=elements.get(row).child(20).text();
				//System.out.println("StrickePriceAt= "+ i);
				
				CALLSOI=CALLSOI.replaceAll(",", "");
				CALLSLTP=CALLSLTP.replaceAll(",", "");
				PUTOI=PUTOI.replaceAll(",", "");
				PUTLTP=PUTLTP.replaceAll(",", "");
				StrikePrice=StrikePrice.replaceAll(",", "");
				parameters=new Parameters(StrikePrice, new Call(CALLSOI, CALLSLTP),
						new Put(PUTOI, PUTLTP));
				parametersList.add(parameters);
			//	System.out.println("In service "+ nseindiaResponse.toString());
	
			}
	
			 Date cDate = new Date();
			 String fDate = new SimpleDateFormat("dd-MM-yyyy").format(cDate);
			 String fTime = new SimpleDateFormat("HH:mm:ss").format(cDate);
			
			 parametersSnapshot=new ParametersSnapshot(fDate,fTime, snapSubHeading, MeanStrikePrice,"mean",index, expiryDate,parametersList);
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(parametersRepository!=null)
			parametersRepository.save(parametersSnapshot);

		return parametersSnapshot;
	}
	

	public ParametersSnapshot currentStrickPrice(String index,String expiryDate, String meanStrickPrice)
	{
		
		System.out.println("currentStrickPrice inputs:" + index + " "+ expiryDate + " "+ meanStrickPrice);
		Element table=null;
		Element table2=null;
		Parameters parameters=null;
		ParametersSnapshot parametersSnapshot=null;
		List<Parameters> parametersList=new ArrayList<>();
		
		try {
			String URL="https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?segmentLink=17&instrument=OPTIDX&symbol="
						+ index +"&date="+ expiryDate;
			Document doc = Jsoup.connect(URL).get();
			
			table = doc.select("table").get(2);
			table2=doc.select("table").get(0);
			
			Elements elements = table.select("tr");
			int row=1;
			String CALLSOI=null;
			String CALLSLTP=null;
			String PUTOI=null;
			String PUTLTP=null;
			String StrikePrice=null;
			int StrikePriceAtRow=0;
			
			//System.out.println(table2.select("td").next().text());
			String snapSubHeading=table2.select("td").next().text();
			while(row<elements.size()-2)
			{
			//	System.out.println("Childs= "+ elements.get(row).children().size());
			//	System.out.println("row="+row);
					
					StrikePrice=elements.get(row).child(11).select("td[class=grybg]").text();
					if(StrikePrice.equals(meanStrickPrice))
					{
						StrikePriceAtRow=row;
					}
	
				row++;
			}
			
			
			//System.out.println("StrickePriceAt= "+ StrikePriceAtRow);
			for(int i=StrikePriceAtRow-7;i<=StrikePriceAtRow+7;i++)
			{
				
				row=i;
				CALLSOI=elements.get(row).child(2).text();
				StrikePrice=elements.get(row).child(11).text();
				CALLSLTP=elements.get(row).child(5).text();
				PUTLTP=elements.get(row).child(17).text();
				PUTOI=elements.get(row).child(20).text();
				//System.out.println("StrickePriceAt= "+ i);
				
				CALLSOI=CALLSOI.replaceAll(",", "");
				CALLSLTP=CALLSLTP.replaceAll(",", "");
				PUTOI=PUTOI.replaceAll(",", "");
				PUTLTP=PUTLTP.replaceAll(",", "");
				StrikePrice=StrikePrice.replaceAll(",", "");
				parameters=new Parameters(StrikePrice, new Call(CALLSOI, CALLSLTP),
						new Put(PUTOI, PUTLTP));
				parametersList.add(parameters);
			//	System.out.println("In service "+ nseindiaResponse.toString());
	
			}
	
			 Date cDate = new Date();
			 String fDate = new SimpleDateFormat("dd-MM-yyyy").format(cDate);
			 String fTime = new SimpleDateFormat("HH:mm:ss").format(cDate);
			
			 parametersSnapshot=new ParametersSnapshot(fDate,fTime, snapSubHeading, meanStrickPrice,"current", index,expiryDate,  parametersList);
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return parametersSnapshot;
	}

	public ParametersSnapshot getMeanStrickPrice(MeanStrickPriceRequest meanStrickPriceRequest)
	{
		ParametersSnapshot dbParametersSnapshot=null;
		try{
			dbParametersSnapshot=parametersRepository.findTop1ByFlagAndSnapDateOrderBySnapDateDesc("mean",meanStrickPriceRequest.getSnapDate());
		}
		catch(Exception e)
		{
			LOG.info(e.getStackTrace().toString());
		}
		return dbParametersSnapshot;
	}
	
}
