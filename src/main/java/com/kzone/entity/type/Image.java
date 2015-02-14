package com.kzone.entity.type;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Image implements BinaryType{

	
	private String 			      format;
	private BufferedInputStream   file;
	private String 			      path;
	
	@Column(nullable=false,length=255)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path  =  path;
	}
	
	@Transient
	public BufferedInputStream getFile() {
		if(file == null){
			loadFile();
		}
		return file;
	}

	@Transient
	public String getFileFormat() {
		return format;
	}


	private final void loadFile(){
		InputStream  resource  =  this.getClass().getResourceAsStream(path);
		file  =  new BufferedInputStream(resource);
	}
	
}
