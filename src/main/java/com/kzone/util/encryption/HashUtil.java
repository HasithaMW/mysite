package com.kzone.util.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Main interface of the <b>Hashing</b>. <b>Implementation defines</b> how the hashing and validation should happens
 * It is better to use salted hashing.
 * @author kasun
 * @version 1.0.1
 */
public interface HashUtil {

	/**
	 * 
	 * @param rawString to hash.
	 * @return hashed string. May be salted
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public String createHash(String rawString)throws NoSuchAlgorithmException,InvalidKeySpecException ;
	
	/**
	 * Validates a password using a hash.
	 *
	 * @param  password the password to check
	 * @param  correctHash the hash of the valid password
	 * @return true if the password is correct, false if not
	 */
	public Boolean validateString(String password, String correctHash)throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	
}
