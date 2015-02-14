package com.kzone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Tag extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Column(nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
