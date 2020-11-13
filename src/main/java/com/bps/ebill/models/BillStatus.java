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
@Table(name = "bill_status", uniqueConstraints = { @UniqueConstraint(name = "bill_status_uq_code", columnNames = "code") })
public class BillStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", length = 10)
	private String code;

	private String name;

	private boolean isActive;
	
}
