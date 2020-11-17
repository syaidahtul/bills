package com.bps.ebill.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bps.ebill.dto.BillDTO;
import com.bps.ebill.models.BillStatus;
import com.bps.ebill.models.Bills;
import com.bps.ebill.models.Categories;
import com.bps.ebill.repository.BillRepository;
import com.bps.ebill.repository.BillStatusRepository;
import com.bps.ebill.repository.CategoryRepository;
import com.bps.ebill.services.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BillStatusRepository statusRepository;
	
	@Override
	public List<BillDTO> getBillList() {
		List<Bills> bills = billRepository.findAll();
		List<BillDTO> billDTOList =
				(List<BillDTO>) bills.stream()
		            .map(objects -> new BillDTO(objects))
		            .collect(Collectors.toList());
		return billDTOList;
	}

	@Override
	public List<BillStatus> getStatusList() {
		List<BillStatus> statuses = statusRepository.findAll();
		return statuses;
	}

	@Override
	public int getDuplicateNewBill(String billCategory, String receiver, BigDecimal amount, Date billDate, String status) {
		List<Bills> bills = billRepository.findDuplicateBill(billCategory, receiver, amount, billDate, status);
		return bills.size();
	}

	@Override
	public BillDTO save(BillDTO billDTO) {
		Bills bill = this.dtoToObj(billDTO); 
		bill = billRepository.save(bill);
		billDTO.setId(bill.getId());
		return billDTO;
	}

	private Bills dtoToObj(BillDTO dto) {
		Bills bill = new Bills();
		bill.setId(dto.getId());
		bill.setBillStatus(this.getStatus(dto.getBillStatus()));
		bill.setBillCategory(this.getCategory(dto.getBillCategory()));
		bill.setReceiver(dto.getReceiver());
		bill.setAmount(dto.getAmount());
		bill.setBillReceivedDate(dto.getBillReceivedDate());
		bill.setBillDate(dto.getBillDate());
		bill.setContractNo(dto.getContractNo());
		bill.setRemarks(dto.getRemarks());
		bill.setVotCode(dto.getVotCode());
		bill.setPtjCode("");
		bill.setDepartmentCode("");
		return null;
	}

	private BillStatus getStatus(String billStatus) {
		return statusRepository.findById(billStatus).get();
	}

	private Categories getCategory(String billCategory) {
		return categoryRepository.findById(billCategory).get();
	}
	
	
}
