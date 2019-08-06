package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data    
@NoArgsConstructor
@AllArgsConstructor
public class ParametersSnapshot {

	private String snapDate;
	private String snaptime;
	private String snapSubHeading;
	private String meanStrikePrice;
	private String flag;
	private String index;
	private String expiryDate;
	private List<Parameters> parameters;
	
}


