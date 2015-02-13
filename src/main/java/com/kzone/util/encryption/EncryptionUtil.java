package com.kzone.util.encryption;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * <p>Main <li>interface</li> for encryption and decryption 
 * Implementation will decide the witch encryption/decryption method to use.
 * Implementation may use .properties file to get key, algorithm and cipher</p>
 * 
 * @author kasun
 *	
 * @version 1.0.1
 */
public interface EncryptionUtil {

	/**
	 * Use to encrypt the raw String. 
	 * 
	 * @param rawString to encrypt
	 * @return encrypted string
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public String encrypt(String rawString)throws GeneralSecurityException,UnsupportedEncodingException;
	
	/**
	 * Use to decrypt the encrypted string.
	 * 
	 * @param encryptedString
	 * @return
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public String decrypt(String encryptedString)throws GeneralSecurityException,UnsupportedEncodingException;
	
}
