package com.example.model;

public class Call{
	private String OI;
	private String LTP;
	
	public Call(String oI, String lTP) {
		super();
		OI = oI;
		LTP = lTP;
	}
	public String getOI() {
		return OI;
	}
	public void setOI(String oI) {
		OI = oI;
	}
	public String getLTP() {
		return LTP;
	}
	public void setLTP(String lTP) {
		LTP = lTP;
	}
	@Override
	public String toString() {
		return "Call [OI=" + OI + ", LTP=" + LTP + "]";
	}
	
}



