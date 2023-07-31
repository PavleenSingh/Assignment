package com.dreamRealty.model;

import java.util.Date;

public class Property {
	private int PropertyId;
	private String AgentName;
	private double AskingPrice;
	private String Region;
	private String Type;
	private Date ClosingDate;
	
	public Property(String AgentName, double AskingPrice, String Region,String Type, Date ClosingDate) {
		super();
		this.AgentName = AgentName;
		this.AskingPrice = AskingPrice;
		this.Region = Region;
		this.Type=Type;
		this.ClosingDate = ClosingDate;
	}

	public Property() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getPropertyId() {
		return PropertyId;
	}

	public String getAgentName() {
		return AgentName;
	}
	public void setAgentName(String agentName) {
		AgentName = agentName;
	}
	public double getAskingPrice() {
		return AskingPrice;
	}
	public void setAskingPrice(double askingPrice) {
		AskingPrice = askingPrice;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public Date getClosingDate() {
		return ClosingDate;
	}
	public void setClosingDate(Date closingDate) {
		ClosingDate = closingDate;
	}

	@Override
	public String toString() {
		return "Property [AgentName=" + AgentName + ", AskingPrice=" + AskingPrice + ", Region=" + Region + ", Type="
				+ Type + ", ClosingDate=" + ClosingDate + "]";
	}
	
	
	
	
}
