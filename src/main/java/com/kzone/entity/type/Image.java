package com.kzone.entity.type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.hibernate.hql.internal.ast.tree.BinaryOperatorNode;
import org.hibernate.hql.internal.ast.tree.Node;
import org.hibernate.type.Type;

import antlr.SemanticException;

@Embeddable
public class Image implements BinaryType{

	private String format;
	private Byte file;
	
	@Column(nullable=false,length=255)
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPath() {
		
	}
	
	@Transient
	public Byte getFile() {
		return file;
	}

	@Transient
	public String getFileFormat() {
		return format;
	}


}
