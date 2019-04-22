package com.app.election.exception;




public class CandidateNotFoundException extends Exception {
	private long candidatesId;
	
	public CandidateNotFoundException(long candidatesId) {
        super(String.format("Voter is not found with id : '%s'", candidatesId));
        }
}
