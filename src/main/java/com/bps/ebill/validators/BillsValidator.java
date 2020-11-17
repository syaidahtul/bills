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
		
		ValidationUtils.rejectIfEmpty(errors, "bill.receiver", "error.required", new Object[] {""});
		ValidationUtils.rejectIfEmpty(errors, "bill.amount", "error.required", new Object[] {"Amount"});
		
		BillDTO dto = form.getBill();
		
		if (errors.getErrorCount() == 0) {
			// 1. check duplicate bill 
			// "SELECT * FROM dbo.Daftar_Bil where STATUS_BIL <> 'BATAL' AND Nama_Penerima like ? and Amaun like ? and Tarikh_Tuntutan = ? and Kategori_Bil like ?"
			int duplicateRecord = service.getDuplicateNewBill(dto.getBillCategory(), dto.getReceiver(), dto.getAmount(), dto.getBillDate(), "BATAL");
			if (duplicateRecord > 0) {
				errors.reject("error.duplicate", new Object[] { dto.getReceiver() }, "error.duplicate");
			}
		}
	}

}
