package com.kzone.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

import com.kzone.entity.type.Address;
import com.kzone.entity.type.Image;
import com.kzone.entity.type.Name;

@Entity
public class Member extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private Name    name;
	private Address address;
	private Date    dob;
	private String  telephone;
	private String  email;
	private String  password;
	private Image   profileImage;
	
	private Set<Post> posts = new HashSet<>();
	
	@Embedded
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	
	@Embedded
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Column(nullable=true)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(nullable=true,length=15)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(nullable=false,length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Embedded
	public Image getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}
	

	
}
