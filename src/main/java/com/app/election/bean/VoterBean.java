package com.app.election.bean;

import javax.validation.constraints.NotBlank;

public class VoterBean {
	 private Long id;
	    @NotBlank
	    private String name;
	    @NotBlank
	    private String fathersName;
	    @NotBlank
	    private String gender;
	    @NotBlank
	    private String dateofBirth;
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
		public String getFathersName() {
			return fathersName;
		}
		public void setFathersName(String fathersName) {
			this.fathersName = fathersName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDateofBirth() {
			return dateofBirth;
		}
		public void setDateofBirth(String dateofBirth) {
			this.dateofBirth = dateofBirth;
		}
		

}
