package com.kzone.util.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SpringPasswordHashing implements HashUtil {
	
	private  BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();

	@Override
	public String createHash(String rawString) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		return encoder.encode(rawString);
	}

	@Override
	public Boolean validateString(String password, String correctHash)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		return encoder.matches(password, correctHash);
		
	}

}
