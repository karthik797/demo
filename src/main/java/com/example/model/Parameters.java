package com.example.model;

import org.springframework.stereotype.Component;



@Component
public class Parameters {


	private String Index;
	private String ExpiryDate;
	private String StrikePrice;
	private Call Call;
	private Put Put;
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
	public String getStrikePrice() {
		return StrikePrice;
	}
	public void setStrikePrice(String strikePrice) {
		StrikePrice = strikePrice;
	}
	public Call getCall() {
		return Call;
	}
	public void setCall(Call call) {
		Call = call;
	}
	public Put getPut() {
		return Put;
	}
	public void setPut(Put put) {
		Put = put;
	}
	public Parameters(String index, String expiryDate, String strikePrice, com.example.model.Call call,
			com.example.model.Put put) {
		super();
		Index = index;
		ExpiryDate = expiryDate;
		StrikePrice = strikePrice;
		Call = call;
		Put = put;
	}
	public Parameters() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Parameters [Index=" + Index + ", ExpiryDate=" + ExpiryDate + ", StrikePrice=" + StrikePrice + ", Call="
				+ Call + ", Put=" + Put + "]";
	}
	
	
}

