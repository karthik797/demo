package com.example.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Component
@Accessors(chain = true)
@Data    
@NoArgsConstructor
@AllArgsConstructor
public class NseindiaResponse {

	private String callschngInOI;
	private String callsLTP;
	private String putChngInOI;
	private String putLTP;
	private String strikePrice;
	
	
	
	
}
