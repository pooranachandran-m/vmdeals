package com.vm.retail.vo;

public class Deal {
	
	private String dealId;
	private String dealName;
	private String dealDescription;
	
	
	
	public Deal() {
		super();
	}
	public Deal(String dealId, String dealName, String dealDescription) {
		super();
		this.dealId = dealId;
		this.dealName = dealName;
		this.dealDescription = dealDescription;
	}
	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getDealName() {
		return dealName;
	}
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	public String getDealDescription() {
		return dealDescription;
	}
	public void setDealDescription(String dealDescription) {
		this.dealDescription = dealDescription;
	}

}
