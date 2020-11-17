package com.bps.ebill.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bps.ebill.models.Bills;

@Repository
public interface BillRepository extends JpaRepository<Bills, Long>{

	@Query("select receiver, amount from Bills where billCategory.code = :category and receiver = :receiver and amount = :amount and billDate = :billDate and billStatus.code = :status")
	List<Bills> findDuplicateBill(@Param("category") String billCategory, @Param("receiver") String receiver, @Param("amount") BigDecimal amount, 
			@Param("billDate") Date billDate, @Param("status") String status);

	List<Bills> findAllByVoucherNo(String voucherNo);

}
