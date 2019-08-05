package com.example.schedulers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.model.NseindiaResponse;
import com.example.model.Parameters;
import com.example.model.ParametersSnapshot;
import com.example.repository.ParametersRepository;
import com.example.service.ParametersService;

@Component
public class EventCreator {
    private static final Logger LOG = LoggerFactory.getLogger(EventCreator.class);
    
    @Autowired
    ParametersService parametersService;
   
    @Autowired
    ParametersRepository parametersRepository;
   
    @Autowired
    Parameters parameters;
    
    @Autowired
    NseindiaResponse nseindiaResponse;
    
    TimerTask tt=null;
    
    @Scheduled(cron = "0 00 2 * * ?")
    public void publish() {
       
        LOG.info("Publish started at = ", LocalDateTime.now());
        
        Timer t = new Timer();  
        
        tt= new TimerTask() {  
            @Override  
            public void run() {  
                insertStackValues(); 
                if( new Date().getHours()==2 && new Date().getMinutes()==1)
                {
                	tt.cancel();
                }
            };  
        };  
        t.scheduleAtFixedRate(tt,new Date(),10000);  
       
           }
    public void insertStackValues()
    {
    	
    	System.out.println("Task Timer on Fixed Rate" + new Date());
    	try{
    		
    		ParametersSnapshot parametersSnapshot=parametersService.strickPrice("BANKNIFTY", "8AUG2019");
    	
    	
			parametersRepository.save(parametersSnapshot);
			System.out.println(parametersRepository.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}  
          
 
    
    /*@Scheduled(fixedRate = 10000)
    public void create() {
        final LocalDateTime start = LocalDateTime.now();
        System.out.println("Slot = "+ start.now());
    }*/
