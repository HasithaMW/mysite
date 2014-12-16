package com.kzone.entity.type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Image implements BinaryType{

	private String format;
	private Byte file;
	
	@Column(nullable=false,length=255)
	public String getPath() {
		return null;
	}

	public void setPath(String path) {
		
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
