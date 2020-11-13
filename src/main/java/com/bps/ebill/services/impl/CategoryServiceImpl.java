package com.bps.ebill.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bps.ebill.dto.CategoryDTO;
import com.bps.ebill.models.Categories;
import com.bps.ebill.repository.CategoryRepository;
import com.bps.ebill.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> getCategoryList() {
		List<Categories> categories = categoryRepository.findAll();
		List<CategoryDTO> categoryDTOList =
				(List<CategoryDTO>) categories.stream()
		            .map(objects -> new CategoryDTO(objects))
		            .collect(Collectors.toList());
		return categoryDTOList;
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		Categories category = new Categories(categoryDTO.getCode(), categoryDTO.getName(), true);
		category = categoryRepository.save(category);
		return new CategoryDTO(category);
	}

	@Override
	public CategoryDTO update(CategoryDTO categoryDTO) {
		categoryRepository.updateByCode(categoryDTO.getName(),categoryDTO.isActive(),categoryDTO.getCode());
		return null;
	}

	@Override
	public CategoryDTO delete(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findByCode(String categoryCode) {
		Optional<Categories> category = categoryRepository.findById(categoryCode);
		return category.isPresent();
	}
	
}
