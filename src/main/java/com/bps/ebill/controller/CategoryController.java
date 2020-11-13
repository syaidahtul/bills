package com.bps.ebill.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bps.ebill.dto.CategoryDTO;
import com.bps.ebill.forms.CategoryForm;
import com.bps.ebill.helpers.WebConstant;
import com.bps.ebill.services.CategoryService;
import com.bps.ebill.validators.CategoriesValidator;

@Controller
@RequestMapping("/secured/setup")
@SessionAttributes({ "categoryForm" })
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/category")
	public String getCategoriesView(Locale locale, HttpServletRequest req, Model model) {
		model.addAttribute("categoryForm", new CategoryForm());
		return "secured.category.list";
	}
	
	@GetMapping(value = "/categories")
	public @ResponseBody List<CategoryDTO> getCategoryList() {
		return categoryService.getCategoryList();
	}
	
	@PostMapping(value = "/category")
	public String postCategoryList(Locale locale, HttpServletRequest req, HttpServletResponse resp, Model model,
			@ModelAttribute("categoryForm") CategoryForm categoryForm, BindingResult result) {

		if (WebConstant.ACTION_BACK.equalsIgnoreCase(categoryForm.getAction())) {
			return WebConstant.VIEW_DASHBOARD;
		}
		
		if (WebConstant.ACTION_SEARCH.equalsIgnoreCase(categoryForm.getAction())) {
			this.searchCategory(categoryForm, result, model);
		}
		
		if (WebConstant.ACTION_NEW.equalsIgnoreCase(categoryForm.getAction())) {
			this.newCategory(categoryForm, result, model);
		}
		
		return "secured.category.list";
	}
	
	private String searchCategory(CategoryForm categoryForm, BindingResult result, Model model) {
		// TODO Auto-generated method stub
		return "secured.category.list";
	}

	public String newCategory(@Valid @RequestBody CategoryForm categoryForm, BindingResult result, Model model) {
		
		CategoriesValidator validator = new CategoriesValidator(categoryService);
		validator.validate(categoryForm, result);
		
		if (result.hasErrors()) {

		}
		
		categoryService.save(categoryForm.getCategory());    
		return "";
	}
	
	@RequestMapping(value = "/category/", method = RequestMethod.PUT)    
	public void updateCategory(@RequestBody CategoryForm category) {    
		categoryService.update(category.getCategory());    
	}      
	
	@RequestMapping(value = "/category/delete", method = RequestMethod.DELETE)    
	public void deleteCategory(@RequestBody CategoryForm category) {    
		categoryService.delete(category.getCategory());    
	}
	
}
