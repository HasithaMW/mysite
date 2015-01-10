package com.kzone.util.encryption;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public interface EncryptionUtil {

	public String encrypt(String rawString)throws GeneralSecurityException,UnsupportedEncodingException;
	
	public String decrypt(String encryptedString)throws GeneralSecurityException,UnsupportedEncodingException;
	
}
