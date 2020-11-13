package com.bps.ebill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bps.ebill.models.Bills;

@Repository
public interface BillRepository extends JpaRepository<Bills, Long>{

}
