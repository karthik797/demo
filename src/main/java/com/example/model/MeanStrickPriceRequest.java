package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data    
@NoArgsConstructor
@AllArgsConstructor
public class MeanStrickPriceRequest {
 
	private String index;
	private String snapDate;

}