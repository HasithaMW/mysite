package com.kzone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.kzone.util.encryption.annotation.Hash;

@Entity
public class User extends BaseEntity  {

	private static final long serialVersionUID = 1L;
	
	
	private String userName;
	private String lastName;

	
	@Column
	@Hash
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@Override
	public String toString() {
		return this.getUserName();
	}
}
