package com.kzone.entity.type;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

	private String firstName;
	private String middleName;
	private String lastName;
	
	@Column(nullable=false,length=255)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(nullable=true,length=255)
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
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
