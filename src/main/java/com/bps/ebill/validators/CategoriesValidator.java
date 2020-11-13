package com.bps.ebill.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bps.ebill.dto.CategoryDTO;
import com.bps.ebill.forms.CategoryForm;
import com.bps.ebill.services.CategoryService;

import org.springframework.stereotype.Component;

@Component
public class CategoriesValidator implements Validator {

	private CategoryService categoryService;
	
	public CategoriesValidator(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoryDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		CategoryForm form = CategoryForm.class.cast(obj);
		
		ValidationUtils.rejectIfEmpty(errors, "category.code", "error.required");
		ValidationUtils.rejectIfEmpty(errors, "category.name", "error.required");
		
		boolean categoryCount = categoryService.findByCode(form.getCategory().getCode());
		
		if (categoryCount){
			errors.reject("error.duplicate", new Object[] { "category", form.getCategory().getCode() }, "error");
		}
	}

}
