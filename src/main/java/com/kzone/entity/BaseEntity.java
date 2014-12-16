package com.kzone.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7334646565828298822L;
	private Long id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;

	@Id
	@TableGenerator(name = "ID_GEN", table = "idGen", 
		pkColumnName = "genName", pkColumnValue = "idGen", 
		valueColumnName = "GenVal", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="ID_GEN")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = true)
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column(nullable = true)
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
