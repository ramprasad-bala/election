package com.app.election.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "Voter")
public class Voter {
	
	
	@Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String fathersName;
    @NotBlank
    private String gender;
    @NotBlank
    private String dateofBirth;
	
   public Voter() {
		super();
	}
   
	public Voter(Long id, @NotBlank String name1, @NotBlank String fathersname, @NotBlank String gender1,
			@NotBlank String dateofBirth1) {
		super();
		this.id = id;
		name = name1;
		fathersName = fathersname;
		gender = gender1;
		dateofBirth = dateofBirth1;
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
	
	public void setName(String name1) {
		name = name1;
	}
	
	public String getFathersName() {
		return fathersName;
	}
	
	public void setFathersName(String fathersname) {
		fathersName = fathersname;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender1) {
		gender = gender1;
	}
	
	public String getDateofBirth() {
		return dateofBirth;
	}
	
	public void setDateofBirth(String dateofBirth1) {
		dateofBirth = dateofBirth1;
	}
    
    
}