package com.kzone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Post extends BaseEntity {

	private String title;
	private String body;
	private String conclusion;
	
	private Member createdBy;
	private Set<Comment> comments;
	private Set<Tag> tags = new HashSet<Tag>();
	
	
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
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="createdBy",nullable=false)
	public Member getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Member createdBy) {
		this.createdBy = createdBy;
	}
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="post",cascade={CascadeType.REMOVE})
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.REMOVE},targetEntity=Tag.class)
	@JoinTable(name = "postTag", joinColumns = { 
			@JoinColumn(name = "post", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "tag", 
					nullable = false, updatable = false) })
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
}
