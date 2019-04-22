package com.app.election.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.election.entity.Candidate;

@Repository
public interface CandidatesRepo extends JpaRepository<Candidate, Long> {

	@Query("SELECT u FROM Candidate u WHERE u.approval = ?1")
	List<Candidate> findUserByName(String name);

}
