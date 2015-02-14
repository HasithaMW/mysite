package com.kzone.entity.type;

import java.io.BufferedInputStream;


public interface BinaryType {

	String getPath();
	 void setPath(String path);
	

	BufferedInputStream getFile();
	String getFileFormat();
	
}
