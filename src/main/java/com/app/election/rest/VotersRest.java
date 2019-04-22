package com.app.election.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.election.entity.Voter;
import com.app.election.exception.VoterNotFoundException;
import com.app.election.repository.VotersRepo;

@RestController
public class VotersRest {

	@Autowired
	VotersRepo votersRepository;

	@GetMapping("/voters")
	public List<Voter> getAllVoters() {
		return votersRepository.findAll();
	}

	@PostMapping("/voters")
	public Voter createVoter(@Valid @RequestBody Voter voter) {
		return votersRepository.save(voter);
	}

	@GetMapping("/voters/{id}")
	public Voter getVoterById(@PathVariable(value = "id") Long votersId) throws VoterNotFoundException {
		return votersRepository.findById(votersId).orElseThrow(() -> new VoterNotFoundException(votersId));
	}

	@PutMapping("/voters/{id}")
	public Voter updateVoter(@PathVariable(value = "id") Long votersId, @Valid @RequestBody Voter votersDetails)
			throws VoterNotFoundException {
		Voter voter = votersRepository.findById(votersId).orElseThrow(() -> new VoterNotFoundException(votersId));
		voter.setName(votersDetails.getName());
		voter.setFathersName(votersDetails.getFathersName());
		voter.setGender(votersDetails.getGender());
		voter.setDateofBirth(votersDetails.getDateofBirth());
		Voter updatedVoters = votersRepository.save(voter);
		return updatedVoters;
	}

	@DeleteMapping("/voters/{id}")
	public ResponseEntity<?> deleteVoter(@PathVariable(value = "id") Long votersId) throws VoterNotFoundException {
		Voter voter = votersRepository.findById(votersId).orElseThrow(() -> new VoterNotFoundException(votersId));

		votersRepository.delete(voter);
		return ResponseEntity.ok().build();
	}

}
