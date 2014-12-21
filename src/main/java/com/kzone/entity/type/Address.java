package com.kzone.entity.type;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String streetAddress;
	private String city;
	private String town;
	private String country;
	
	@Column(nullable=false,length=255)
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Column(nullable=false,length=255)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(nullable=false,length=255)
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	@Column(nullable=false,length=255)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return getStreetAddress() + " " + getCity() +" "+getTown()+" "+getCountry();
	}
	
}
