package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class NseindiaRequest {
	
	private String Index;
	private String ExpiryDate;
	public String getIndex() {
		return Index;
	}
	public void setIndex(String index) {
		Index = index;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "NseindiaRequest [Index=" + Index + ", ExpiryDate=" + ExpiryDate + "]";
	}
	
	
	

}
