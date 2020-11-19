package com.bps.ebill.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bps.ebill.dto.BillDTO;
import com.bps.ebill.forms.BillForm;
import com.bps.ebill.helpers.AppConstant;
import com.bps.ebill.helpers.WebConstant;
import com.bps.ebill.services.BillService;
import com.bps.ebill.services.CategoryService;
import com.bps.ebill.validators.BillsValidator;

@Controller
@RequestMapping("/secured/bill")
@SessionAttributes({ "billForm" })
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private CategoryService categoryService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat(AppConstant.DATE_FORMAT);
		binder.registerCustomEditor(Date.class, "bill.billDate", new CustomDateEditor(sdf, true));
		binder.registerCustomEditor(Date.class, "bill.billReceivedDate", new CustomDateEditor(sdf, true));

		DecimalFormat decimalFormat = new DecimalFormat();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		decimalFormat.setDecimalFormatSymbols(symbols);
		decimalFormat.setMaximumFractionDigits(2);
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, decimalFormat, true));
	}
	
	@GetMapping()
	public String getBillsView(Locale locale, HttpServletRequest req, Model model) {
		BillForm billForm = new BillForm(); 
		billForm.setBillStatus(billService.getStatusList());
		billForm.setCategories(categoryService.getCategoryList());
		model.addAttribute("billForm", billForm);
		return "secured.bills";
	}
	
	@GetMapping("/list")
	public @ResponseBody List<BillDTO> getBillList() {
		return billService.getBillList();
	}

	@PostMapping()
	public String postBillList(Locale locale, HttpServletRequest req, HttpServletResponse resp, Model model,
			@ModelAttribute("billForm") BillForm billForm, BindingResult result) {

		if (WebConstant.ACTION_BACK.equalsIgnoreCase(billForm.getAction())) {
			return WebConstant.VIEW_DASHBOARD;
		}
		
		if (WebConstant.ACTION_SEARCH.equalsIgnoreCase(billForm.getAction())) {
		}
		
		if (WebConstant.ACTION_NEW.equalsIgnoreCase(billForm.getAction())) {
			this.reset(billForm, model);
			return "secured.bill.new";
		}
		
		return "secured.bills";
	}

	@PostMapping("/new")
	public String newBill(Locale locale, HttpServletRequest req, HttpServletResponse resp, Model model,
			@ModelAttribute("billForm") BillForm billForm, BindingResult result) {
		
		if (WebConstant.ACTION_CLEAR.equalsIgnoreCase(billForm.getAction())) {
			this.reset(billForm, model);
			return "secured.bill.new";
		} else {
			BillsValidator validator = new BillsValidator(billService);
			validator.validate(billForm, result);
			
			if (result.hasErrors()) {
				return "secured.bill.new";
			} else {
				billService.save(billForm.getBill());
				billForm.setBill(new BillDTO());
				return "secured.bills";
			}
		}
	}
	
	private void reset(BillForm billForm, Model model) {
		BillDTO dto = new BillDTO();
		dto.setBillStatus("BARU");
		billForm.setBill(dto);
		model.addAttribute("billForm", billForm);
	}
	
}
