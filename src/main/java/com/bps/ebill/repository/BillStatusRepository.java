package com.bps.ebill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bps.ebill.models.BillStatus;

@Repository
public interface BillStatusRepository extends JpaRepository<BillStatus, Long>{

}
