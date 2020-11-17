package com.bps.ebill.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bps.ebill.dto.BillDTO;
import com.bps.ebill.forms.BillForm;
import com.bps.ebill.services.BillService;

public class BillsValidator implements Validator {

	private BillService service;
	
	public BillsValidator(BillService service) {
		this.service = service;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BillForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		BillForm form = BillForm.class.cast(obj);

		ValidationUtils.rejectIfEmpty(errors, "bill.billCategory", "error.required", new Object[] {"Amount"});
		ValidationUtils.rejectIfEmpty(errors, "bill.receiver", "error.required", new Object[] {"Receiver's Name"});
		ValidationUtils.rejectIfEmpty(errors, "bill.amount", "error.required", new Object[] {"Amount"});
		ValidationUtils.rejectIfEmpty(errors, "bill.billReceivedDate", "error.required", new Object[] {"Amount"});
		ValidationUtils.rejectIfEmpty(errors, "bill.reference", "error.required", new Object[] {"Amount"});
		ValidationUtils.rejectIfEmpty(errors, "bill.billDate", "error.required", new Object[] {"Amount"});
		// ValidationUtils.rejectIfEmpty(errors, "bill.votCode", "error.required", new Object[] {"bill.votCode"});
		
		BillDTO dto = form.getBill();
		
		if (errors.getErrorCount() == 0) {
			// 1. check duplicate bill
			int duplicateRecord = service.getDuplicateNewBill(dto.getBillCategory(), dto.getReceiver(), dto.getAmount(), dto.getBillDate(), "BATAL");
			if (duplicateRecord > 0) {
				errors.reject("error.duplicate", new Object[] { dto.getReceiver() }, "error.duplicate");
			}
		}
	}
	
	public void validateEdit(Object obj, Errors errors) {
		BillForm form = BillForm.class.cast(obj);
		
		ValidationUtils.rejectIfEmpty(errors, "bill.receiver", "error.required", new Object[] {"Receiver's Name"});
		ValidationUtils.rejectIfEmpty(errors, "bill.amount", "error.required", new Object[] {"Amount"});
		
		BillDTO dto = form.getBill();
		
		if (errors.getErrorCount() == 0) {
			// 1. check duplicate voucher no
			int duplicateVoucher = service.getDuplicateVoucherNo(dto.getVoucherNo());
			if (duplicateVoucher > 0) {
				errors.reject("error.duplicate", new Object[] { dto.getVoucherNo() }, "error.duplicate");
			}
		}
	}

}
