package com.bps.ebill.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bps.ebill.dto.BillDTO;
import com.bps.ebill.models.BillStatus;
import com.bps.ebill.models.Bills;
import com.bps.ebill.repository.BillRepository;
import com.bps.ebill.repository.BillStatusRepository;
import com.bps.ebill.services.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	
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
	
}
