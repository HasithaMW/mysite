package com.kzone.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation.Family;

@Entity
public class Comment extends BaseEntity {

	private String comment;
	
	private Post post;
	private Comment parentComment;
	private Set<Comment> comments;
	
	@Column(nullable=false)
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="post")
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="parentComment")
	public Comment getParentComment() {
		return parentComment;
	}
	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="parentComment",cascade={CascadeType.REMOVE})
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
