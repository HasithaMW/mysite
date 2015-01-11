package com.kzone.entity.type;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.kzone.util.encryption.annotation.Encrypt;

@Embeddable
public class Name {

	private String firstName;
	private String middleName;
	private String lastName;
	
	@Encrypt
	@Column(nullable=false,length=255)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Encrypt
	@Column(nullable=true,length=255)
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Encrypt
	@Column(nullable=false,length=255)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return getFirstName() + " "+getMiddleName() +" " +getLastName();
	}
	
}
