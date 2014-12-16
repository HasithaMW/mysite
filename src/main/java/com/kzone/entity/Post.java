package com.kzone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Post extends BaseEntity {

	private String title;
	private String body;
	private String conclusion;
	
	@Column(nullable=false,length=255)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(nullable=false)
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Column(nullable=false,length=255)
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	
	
}
