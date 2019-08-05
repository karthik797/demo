package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class NseindiaResponse {

	public NseindiaResponse() {
		super();
	}
	private String CallschngInOI;
	private String CallsLTP;
	private String PutChngInOI;
	private String PutLTP;
	private String StrikePrice;
	
	
	
	
	@Override
	public String toString() {
		return "NseindiaResponse [CallschngInOI=" + CallschngInOI + ", CallsLTP=" + CallsLTP + ", PutChngInOI="
				+ PutChngInOI + ", PutLTP=" + PutLTP + ", StrikePrice=" + StrikePrice + "]";
	}
	public String getCallschngInOI() {
		return CallschngInOI;
	}
	public void setCallschngInOI(String callschngInOI) {
		CallschngInOI = callschngInOI;
	}
	public String getCallsLTP() {
		return CallsLTP;
	}
	public void setCallsLTP(String callsLTP) {
		CallsLTP = callsLTP;
	}
	public String getPutChngInOI() {
		return PutChngInOI;
	}
	public void setPutChngInOI(String putChngInOI) {
		PutChngInOI = putChngInOI;
	}
	public String getPutLTP() {
		return PutLTP;
	}
	public void setPutLTP(String putLTP) {
		PutLTP = putLTP;
	}
	public String getStrikePrice() {
		return StrikePrice;
	}
	public void setStrikePrice(String strikePrice) {
		StrikePrice = strikePrice;
	}
	
	
}
