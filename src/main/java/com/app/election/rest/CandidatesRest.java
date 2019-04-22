package com.app.election.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.election.entity.Candidate;
import com.app.election.exception.CandidateNotFoundException;
import com.app.election.repository.CandidatesRepo;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class CandidatesRest {

	@Autowired
	CandidatesRepo candidatesRepository;

	@GetMapping("/candidates")
	public MappingJacksonValue getAllCandidates() {
		List<Candidate> candidate = candidatesRepository.findAll();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party",
				"partysymbol", "totalProperties", "criminalCase", "approval");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(candidate);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/candidate")
	public Candidate getAllCandidate() {
		Candidate candidate = new Candidate();
		candidate.getId();
		candidate.getName();
		candidate.getParty();
		candidate.getPartySymbol();
		candidate.getTotalProperties();
		return candidate;
	}

	@PostMapping("/candidate")
	public MappingJacksonValue createCandidate(@Valid @RequestBody Candidate candidate) {
		Candidate newcandidate = new Candidate();

		newcandidate.setName(candidate.getName());
		newcandidate.setParty(candidate.getParty());
		newcandidate.setCriminalCase(candidate.getCriminalCase());
		newcandidate.setPartySymbol(candidate.getPartySymbol());
		newcandidate.setTotalProperties(candidate.getTotalProperties());
		Candidate updatedVoters = candidatesRepository.save(newcandidate);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party",
				"partysymbol", "totalProperties", "criminalCase", "approval");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(updatedVoters);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/candidate/{id}")
	public MappingJacksonValue getById(@PathVariable(value = "id") Long candidatesId)
			throws CandidateNotFoundException {
		Candidate candidate = candidatesRepository.findById(candidatesId)
				.orElseThrow(() -> new CandidateNotFoundException(candidatesId));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party",
				"partysymbol", "totalProperties", "criminalCase", "approval");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(candidate);
		mapping.setFilters(filters);
		return mapping;
	}

	@PutMapping("/candidate/{id}")
	public MappingJacksonValue updateCandidate(@PathVariable(value = "id") Long candidatesid,
			@Valid @RequestBody Candidate candidateDetails) throws CandidateNotFoundException {
		Candidate candidate = candidatesRepository.findById(candidatesid)
				.orElseThrow(() -> new CandidateNotFoundException(candidatesid));
		candidate.setName(candidateDetails.getName());
		candidate.setParty(candidateDetails.getParty());
		candidate.setPartySymbol(candidateDetails.getPartySymbol());
		candidate.setCriminalCase(candidateDetails.getCriminalCase());
		candidate.setTotalProperties(candidateDetails.getTotalProperties());
		Candidate updatedVoters = candidatesRepository.save(candidate);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party",
				"partysymbol", "totalProperties", "criminalCase", "approval");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(updatedVoters);
		mapping.setFilters(filters);
		return mapping;

	}

	@DeleteMapping("/candidate/{id}")
	public ResponseEntity<?> deleteCandidate(@PathVariable(value = "id") Long candidatesid)
			throws CandidateNotFoundException {
		Candidate candidate = candidatesRepository.findById(candidatesid)
				.orElseThrow(() -> new CandidateNotFoundException(candidatesid));
		candidatesRepository.delete(candidate);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/candidate/{id}/approve")
	public MappingJacksonValue approveById(@PathVariable(value = "id") Long candidatesId)
			throws CandidateNotFoundException {
		Candidate candidate = candidatesRepository.findById(candidatesId)
				.orElseThrow(() -> new CandidateNotFoundException(candidatesId));

		candidate.setApproval("approved");
		Candidate updatedVoters = candidatesRepository.save(candidate);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party",
				"approval");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(updatedVoters);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/candidate/{id}/disapprove")
	public MappingJacksonValue disApproveById(@PathVariable(value = "id") Long candidatesId)
			throws CandidateNotFoundException {
		Candidate candidate = candidatesRepository.findById(candidatesId)
				.orElseThrow(() -> new CandidateNotFoundException(candidatesId));
		candidate.setApproval("disapproved");
		Candidate updatedVoters = candidatesRepository.save(candidate);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party",
				"approval");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(updatedVoters);
		mapping.setFilters(filters);
		return mapping;

	}

	@GetMapping("/candidates/approved")
	public MappingJacksonValue getAllApprovedCandidates() {
		List<Candidate> candidate = candidatesRepository.findUserByName("approved");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party",
				"approval");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(candidate);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/candidate/{id}/vote")
	public MappingJacksonValue voteCandidate(@PathVariable(value = "id") Long candidatesId)
			throws CandidateNotFoundException {
		Candidate candidate = candidatesRepository.findById(candidatesId)
				.orElseThrow(() -> new CandidateNotFoundException(candidatesId));
		candidate.setVotes(candidate.getVotes() + 1);
		Candidate updatedVoters = candidatesRepository.save(candidate);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "party", "approval",
				"votes");

		FilterProvider filters = new SimpleFilterProvider().addFilter("candidatefilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(updatedVoters);
		mapping.setFilters(filters);
		return mapping;

	}

}