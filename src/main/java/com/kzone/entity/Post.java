package com.kzone.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import javax.persistence.Transient;

@Entity
public class Post extends BaseEntity implements Comparable<Post> {

	private static final long serialVersionUID = 1L;
	
	public final BigDecimal MAX_RATE   = new BigDecimal(5);
	public final BigDecimal MIN_RATE   = new BigDecimal(0);
	public final Integer 	MIN_LIKE   = 0;
	public final Integer 	MIN_DISLIE = 0;
	
	private String  title;
	private String  body;
	private String  conclusion;
	private Integer likeCount;
	private Integer dislkeCount;
		
	private Member 		 postedBy;
	private Set<Comment> comments;
	private Set<Tag> 	 tags = new HashSet<Tag>();
	
	
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
	
	@Column(nullable=true)
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	
	@Column(nullable=true)
	public Integer getDislkeCount() {
		return dislkeCount;
	}
	public void setDislkeCount(Integer dislkeCount) {
		this.dislkeCount = dislkeCount;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="postedBy",nullable=false)
	public Member getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(Member postedBy) {
		this.postedBy = postedBy;
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
	
	
	@Transient
	public BigDecimal getRating() {
		if(getLikeCount() == MIN_LIKE){
			return MIN_RATE;
		}else if(dislkeCount == MIN_DISLIE){
			return MAX_RATE;
		}else{
			 BigDecimal setScale = new BigDecimal(getLikeCount()/getDislkeCount()).setScale(3, RoundingMode.HALF_UP);
			 if(setScale.compareTo(MAX_RATE) >= 0){
				return MAX_RATE; 
			 }
			 else{
				 return setScale;
			 }
		}

	}
	
	public void setRating(BigDecimal rating) {
		throw new IllegalArgumentException("Cannot set rating ");
	}
	
	
	public int compareTo(Post compareTo) {
		if(compareTo == null){
			return 1;
		}
		else{
			return compareTo.getRating().compareTo(getRating());
		}
	}

}
