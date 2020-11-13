package com.bps.ebill.forms;

import java.util.List;

import com.bps.ebill.dto.BillDTO;
import com.bps.ebill.dto.CategoryDTO;
import com.bps.ebill.dto.GenericValueNameDTO;
import com.bps.ebill.models.BillStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillForm extends AbstractForm {

	private static final long serialVersionUID = 1L;
	
	private List<BillStatus> billStatus;
	
	private List<CategoryDTO> categories;

	private List<GenericValueNameDTO> votCode;
	
	private BillDTO bill;
	
}
