package com.bps.ebill.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "code", nullable = false, length = 6, unique = true)
	private String code;

	@Column(name = "name", nullable = false, length = 100, unique = true)
	private String name;

	private boolean active;  
	
}
