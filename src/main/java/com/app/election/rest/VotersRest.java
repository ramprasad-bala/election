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

import com.app.election.bean.VoterBean;
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

	@PostMapping("/voter")
	public VoterBean createVoter(@Valid @RequestBody VoterBean voterBean) {
		Voter voter = new Voter();
		voter.setName(voterBean.getName());
		voter.setFathersName(voterBean.getFathersName());
		voter.setDateofBirth(voterBean.getDateofBirth());
		voter.setGender(voterBean.getGender());
		votersRepository.save(voter);
		voterBean.setId(voter.getId());

		return voterBean;
	}

	@GetMapping("/voter/{id}")
	public Voter getVoterById(@PathVariable(value = "id") Long votersId) throws VoterNotFoundException {
		return votersRepository.findById(votersId).orElseThrow(() -> new VoterNotFoundException(votersId));
	}

	@PutMapping("/voter/{id}")
	public VoterBean updateVoter(@PathVariable(value = "id") Long votersId, @Valid @RequestBody VoterBean votersDetails)
			throws VoterNotFoundException {
		Voter voter = votersRepository.findById(votersId).orElseThrow(() -> new VoterNotFoundException(votersId));
		voter.setName(votersDetails.getName());
		voter.setFathersName(votersDetails.getFathersName());
		voter.setGender(votersDetails.getGender());
		voter.setDateofBirth(votersDetails.getDateofBirth());
		votersRepository.save(voter);
		votersDetails.setId(voter.getId());

		return votersDetails;
	}

	@DeleteMapping("/voter/{id}")
	public ResponseEntity<?> deleteVoter(@PathVariable(value = "id") Long votersId) throws VoterNotFoundException {
		Voter voter = votersRepository.findById(votersId).orElseThrow(() -> new VoterNotFoundException(votersId));

		votersRepository.delete(voter);
		return ResponseEntity.ok().build();
	}

}
