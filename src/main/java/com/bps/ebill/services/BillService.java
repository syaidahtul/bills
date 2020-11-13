package com.bps.ebill.services;

import java.util.List;

import com.bps.ebill.dto.BillDTO;
import com.bps.ebill.models.BillStatus;

public interface BillService {

	public List<BillDTO> getBillList();

	public List<BillStatus> getStatusList();

}
