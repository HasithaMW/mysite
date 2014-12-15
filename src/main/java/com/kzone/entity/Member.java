package com.kzone.entity;

import javax.persistence.Entity;

import com.kzone.entity.type.Address;
import com.kzone.entity.type.Image;
import com.kzone.entity.type.Name;

@Entity
public class Member {

	private Long id;
	private Name name;
	private Address address;
	private String email;
	private String password;
	private Image profileImage;
}
