package com.app.election.exception;


public class VoterNotFoundException extends Exception {
	
	private long voters_id;
	public VoterNotFoundException(long voters_id) {
	        super(String.format("Voter is not found with id : '%s'", voters_id));
	        }

}

