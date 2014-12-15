package com.kzone.entity;

import java.sql.Date;

import javax.persistence.Entity;

import com.kzone.entity.type.Address;
import com.kzone.entity.type.Image;
import com.kzone.entity.type.Name;

@Entity
public class Member {

	private Long id;
	private Name name;
	private Address address;
	private Date dob;
	private String telephone;
	private String email;
	private String password;
	private Image profileImage;
	
}
