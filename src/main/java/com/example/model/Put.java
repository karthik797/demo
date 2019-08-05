package com.example.model;

public class Put{	
	@Override
	public String toString() {
		return "Put [OI=" + OI + ", LTP=" + LTP + "]";
	}
	public Put(String oI, String lTP) {
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
	private String OI;
	private String LTP;
}