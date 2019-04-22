package com.app.election.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.election.entity.Voter;


@Repository
public interface VotersRepo extends JpaRepository<Voter,Long> {

}
