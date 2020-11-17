package com.bps.ebill.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bps.ebill.dto.BillDTO;
import com.bps.ebill.models.BillStatus;

public interface BillService {

	public List<BillDTO> getBillList();

	public List<BillStatus> getStatusList();

	public int getDuplicateNewBill(String billCategory, String receiver, BigDecimal amount, Date billDate, String status);

	public int getDuplicateVoucherNo(String voucherNo);

	public BillDTO save(BillDTO bill);

}
