package com.app.election.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "Candidate")
@JsonFilter("candidatefilter")
public class Candidate {
	@Id
	@GeneratedValue
	private Long id;
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

	private String approval = "pending";

	private Integer votes = 0;

	public Candidate() {
		super();
	}

	public Candidate(Long id, @NotBlank String name, @NotBlank String party, @NotBlank String partySymbol,
			@NotBlank String criminalCase, @NotBlank String totalProperties) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.partySymbol = partySymbol;
		this.criminalCase = criminalCase;
		this.totalProperties = totalProperties;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

}