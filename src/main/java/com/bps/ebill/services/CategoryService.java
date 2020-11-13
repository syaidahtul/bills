package com.bps.ebill.services;

import java.util.List;

import com.bps.ebill.dto.CategoryDTO;

public interface CategoryService {

	public List<CategoryDTO> getCategoryList();

	public CategoryDTO save(CategoryDTO category);

	public CategoryDTO update(CategoryDTO category);

	public CategoryDTO delete(CategoryDTO category);
	
	public boolean findByCode(String categoryCode);
	
}
