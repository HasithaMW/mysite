package com.kzone.util.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface HashUtil {

	/**
	 * Returns a salted PBKDF2 hash of the password.
	 *
	 * @param  password the password to hash
	 * @return a salted PBKDF2 hash of the password
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
