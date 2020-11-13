package com.bps.ebill.dto;

import com.bps.ebill.models.Categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	private String code;
	
	private String name;

	private boolean active;
	
	public CategoryDTO(Categories obj) {
		this.code = obj.getCode();
		this.name = obj.getName();
		this.active = obj.isActive();
	}

}
