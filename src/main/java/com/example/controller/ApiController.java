package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.NseindiaRequest;
import com.example.model.NseindiaResponse;
import com.example.model.ParametersSnapshot;
import com.example.schedulers.EventCreator;
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
			
			parametersSnapshot=parametersService.strickPrice(nseindiaRequest.getIndex(), nseindiaRequest.getExpiryDate());
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


