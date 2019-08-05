package com.example.model;

import java.util.List;


public class ParametersSnapshot {

	
	private String SnapDate;
	private String Snaptime;
	private String SnapSubHeading;
	private List<Parameters> parameters;
	
	
	
	
	@Override
	public String toString() {
		return "ParametersSnapshot [SnapDate=" + SnapDate + ", Snaptime=" + Snaptime + ", SnapSubHeading="
				+ SnapSubHeading + ", parameters=" + parameters + "]";
	}
	public ParametersSnapshot(String snapDate, String snaptime, String snapSubHeading, List<Parameters> parameters) {
		super();
		SnapDate = snapDate;
		Snaptime = snaptime;
		SnapSubHeading = snapSubHeading;
		this.parameters = parameters;
	}
	public String getSnapDate() {
		return SnapDate;
	}
	public void setSnapDate(String snapDate) {
		SnapDate = snapDate;
	}
	public String getSnaptime() {
		return Snaptime;
	}
	public void setSnaptime(String snaptime) {
		Snaptime = snaptime;
	}
	public String getSnapSubHeading() {
		return SnapSubHeading;
	}
	public void setSnapSubHeading(String snapSubHeading) {
		SnapSubHeading = snapSubHeading;
	}
	public List<Parameters> getParameters() {
		return parameters;
	}
	public void setParameters(List<Parameters> parameters) {
		this.parameters = parameters;
	}
	
	
}


