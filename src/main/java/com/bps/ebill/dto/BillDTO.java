package com.bps.ebill.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.bps.ebill.models.Bills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {

	private long id;
	
	private String billCategory;

	private String billStatus;

	private String receiver;
	
	private BigDecimal amount;

	private Date billReceivedDate;

	private String reference;

	private Date billDate;

	private String votCode;

	private String contractNo;

	private String remarks;

	private String verifiedBy;

	private Date verifiedDate;

	private String cancelRemarks;

	private Date cancelledDate;
	
	private String cancelledBy;

	private Date voucherDate;

	private String voucherNo;

	private Date voucherVerifiedDate;

	private String voucherVerifiedBy;

	private String voucherSubmissionDate;

	private Date eftDate;

	private Date noOfDays;
	
	private String departmentCode;

	private String stationCode;

	private String ptjCode;	
	
	public BillDTO(Bills dto) {
		this.id=dto.getId();
		this.billCategory=dto.getBillCategory().getName();
		this.billStatus=dto.getBillStatus().getName();
		this.receiver=dto.getReceiver();
		this.amount=dto.getAmount();
		this.billReceivedDate=dto.getBillReceivedDate();
		this.reference=dto.getReference();
		this.billDate=dto.getBillDate();
		this.votCode=dto.getVotCode();
		this.contractNo=dto.getContractNo();
		this.remarks=dto.getRemarks();
		this.verifiedBy=dto.getVerifiedBy();
		this.verifiedDate=dto.getVerifiedDate();
		this.cancelRemarks=dto.getCancelRemarks();
		this.cancelledDate=dto.getCancelledDate();
		this.voucherDate=dto.getVoucherDate();
		this.voucherNo=dto.getVoucherNo();
		this.voucherVerifiedDate=dto.getVoucherVerifiedDate();
		this.voucherVerifiedBy=dto.getVoucherVerifiedBy();
		this.voucherSubmissionDate=dto.getVoucherSubmissionDate();
		this.eftDate=dto.getEftDate();
		this.noOfDays=dto.getNoOfDays();
		this.departmentCode=dto.getDepartmentCode();
		this.stationCode=dto.getStationCode();
		this.ptjCode=dto.getPtjCode();
	}

}
