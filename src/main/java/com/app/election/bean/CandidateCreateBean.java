package com.app.election.bean;

import javax.validation.constraints.NotBlank;

public class CandidateCreateBean {
	@NotBlank
	private String name;
	@NotBlank
	private String party;
	@NotBlank
	private String partySymbol;
	@NotBlank
	private String criminalCase;
	@NotBlank
	private String totalProperties;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getPartySymbol() {
		return partySymbol;
	}
	public void setPartySymbol(String partySymbol) {
		this.partySymbol = partySymbol;
	}
	public String getCriminalCase() {
		return criminalCase;
	}
	public void setCriminalCase(String criminalCase) {
		this.criminalCase = criminalCase;
	}
	public String getTotalProperties() {
		return totalProperties;
	}
	public void setTotalProperties(String totalProperties) {
		this.totalProperties = totalProperties;
	}
	
	

}