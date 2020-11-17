package com.bps.ebill.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bps.ebill.dto.BillDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bills")
public class Bills implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_generator")
	@SequenceGenerator(name="bill_generator", sequenceName = "bill_seq", allocationSize=1, initialValue = 10000)
	@Column(name = "id", nullable = false)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_status_code", referencedColumnName = "code")
	private BillStatus billStatus;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_category_code", referencedColumnName = "code")
	private Categories billCategory;

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
}
