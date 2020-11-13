package com.bps.ebill.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bps.ebill.helpers.WebConstant;
import com.bps.ebill.services.BillService;
import com.bps.ebill.services.CategoryService;

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
	}
	
	@GetMapping()
	public String getBillsView(Locale locale, HttpServletRequest req, Model model) {
		BillForm billForm = new BillForm(); 
		billForm.setCategories(categoryService.getCategoryList());
		model.addAttribute("billForm", billForm);
		return "secured.bills";
	}
	
	@GetMapping("/bills")
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
			billForm.setBill(new BillDTO());
			model.addAttribute("billForm", billForm);
			return "secured.bill.new";
		}
		
		return "secured.bills";
	}
	
	
}
