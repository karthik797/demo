package com.example.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CurrentStrickPriceRequest;
import com.example.model.MeanStrickPriceRequest;
import com.example.model.NseindiaRequest;
import com.example.model.NseindiaResponse;
import com.example.model.ParametersSnapshot;
import com.example.service.ParametersService;

@RestController
public class ApiController {

	 private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);
	 
	@Autowired
	ParametersService parametersService;
	
	@Autowired
	NseindiaResponse nseindiaResponse;
	
	@GetMapping("/api")
	public ParametersSnapshot parameters(@RequestBody NseindiaRequest nseindiaRequest ) {
		LOG.info("Request Body:" + nseindiaRequest.toString());
		ParametersSnapshot parametersSnapshot=null;
		try{
			
			parametersSnapshot=parametersService.meanStrickPrice(nseindiaRequest.getIndex(), nseindiaRequest.getExpiryDate());
			/*for(NseindiaResponse nseindiaResponse: nseindiaResponseList)
			{
				System.out.println(nseindiaResponse.toString());
			}*/
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		LOG.info("Response:" + parametersSnapshot.toString());
		return parametersSnapshot;
	}
	
	@GetMapping("/api/mean-strick-price")
	public List<ParametersSnapshot> getMeanStrickPricefromDb(@RequestHeader Map<String, String> headers) {
		LOG.info("Request headers:" + headers.toString());
		MeanStrickPriceRequest meanStrickPriceRequest=
				new MeanStrickPriceRequest(headers.get("index"),headers.get("snapdate"), headers.get("flag"));
		LOG.info("MeanStrickPriceRequest :" + meanStrickPriceRequest.toString());

		List<ParametersSnapshot> parametersSnapshot=null;
		try{
			
			parametersSnapshot=parametersService.getMeanStrickPrice(meanStrickPriceRequest);
			/*for(NseindiaResponse nseindiaResponse: nseindiaResponseList)
			{
				System.out.println(nseindiaResponse.toString());
			}*/
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		LOG.info("Response:" + parametersSnapshot.toString());
		return parametersSnapshot;
	}
	
	@GetMapping("/api/live-strick-price")
	public ParametersSnapshot getLiveStrickPrice(@RequestHeader Map<String, String> headers) {
		
		LOG.info("Request headers:" + headers.toString());
		CurrentStrickPriceRequest currentStrickPriceRequest=new CurrentStrickPriceRequest(headers.get("index"),headers.get("expirydate"), headers.get("meanstrickprice"));
		LOG.info("CurrentStrickPriceRequest :" + currentStrickPriceRequest.toString());
		
		LOG.info("Request Body:" + currentStrickPriceRequest.toString());
		ParametersSnapshot parametersSnapshot=null;
		try{
		
			parametersSnapshot=parametersService.currentStrickPrice(currentStrickPriceRequest);
			/*for(NseindiaResponse nseindiaResponse: nseindiaResponseList)
			{
				System.out.println(nseindiaResponse.toString());
			}*/
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		LOG.info("Response:" + parametersSnapshot.toString());
		return parametersSnapshot;
	}
}


