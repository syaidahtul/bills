package com.bps.ebill.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bps.ebill.models.VotCode;

@Repository
public interface VotCodeRepository extends CrudRepository<VotCode, String> {

}
