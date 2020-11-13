package com.bps.ebill.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vot_code_temp", uniqueConstraints = { @UniqueConstraint(name = "vot_code_temp_code", columnNames = "bud_code") })
public class VotCode implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "bud_code", length = 50)
	private String budCode;

	@Column(name = "bud_description", length = 500)
	private String budDescription;

	@Column(name = "bud_year", length = 4)
	private int name;

	private boolean isActive;

}
