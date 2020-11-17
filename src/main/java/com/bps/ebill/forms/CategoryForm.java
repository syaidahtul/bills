package com.bps.ebill.forms;

import java.util.Set;

import com.bps.ebill.dto.CategoryDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryForm extends AbstractForm {

	private static final long serialVersionUID = 705214124871219339L;

	public Set<CategoryDTO> categoryList;

	public CategoryDTO searchCategory;
	
	public CategoryDTO category;
}
