package com.kzone.util.encryption;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Singleton
@PropertySource(value = { "classpath:security.properties" })
public class PasswordHash implements HashUtil {

	// this code from https://crackstation.net/hashing-security.htm
	
	@Autowired
	private Environment environment;
	
	//"PBKDF2WithHmacSHA1"
	private 	  String algorithm       = null;
	private  	  int    saltByteSize    = 0;
	private       int    hashByteSize    = 0;
	private       int    iterations      = 1000;

	private final int    iterationIndex   = 0;
	private final int    saltIndex        = 1;
	private final int    hashIndex        = 2;

	
	public String createHash(String password) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		return createHash(password.toCharArray());
	}

	@PostConstruct
	private void PasswordHash(){
		
		String algorithm         =  environment.getRequiredProperty("hash.algorithm");
		int    saltByteSize      =  Integer.parseInt(environment.getRequiredProperty("hash.saltByteSize"));
		int    hashByteSize      =  Integer.parseInt(environment.getRequiredProperty("hash.hashByteSize"));
		
		setHashAlgorithm(algorithm);
		setHashByteSize(hashByteSize);
		setSaltByteSize(saltByteSize);
		
	}
	
	

	private void setHashAlgorithm(String algorithm) {
		
		assert this.algorithm == null : "algorithm is not null, Object is Singleton cant change the value";  
		
		this.algorithm = algorithm;
	}
	

	private void setSaltByteSize(int saltByteSize){
		
		assert saltByteSize      > 24 : "saltByteSize must have a size > 24";
		assert this.saltByteSize == 0 : "saltByteSize is set, Object is Singleton cant change the value";  
		
		this.saltByteSize= saltByteSize;
	}
	

	private void setHashByteSize(int hashByteSize){
		
		assert hashByteSize      > 24 : "hashByteSize must have a size > 24";
		assert this.hashByteSize == 0 : "hashByteSize is set, Object is Singleton cant change the value";  
		
		this.hashByteSize = hashByteSize;
	}
	
	/**
	 * Returns a salted PBKDF2 hash of the password.
	 *
	 * @param  password the password to hash
	 * @return a salted PBKDF2 hash of the password
	 */
	private String createHash(char[] password) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		
		assert algorithm != null : "algoritm cannot be null";
		
		// Generate a random salt
		SecureRandom random = new SecureRandom();
		byte []      salt   = new byte[saltByteSize];
		random.nextBytes(salt);
		// Hash the password
		byte []      hash   = pbkdf2(password, salt, iterations, hashByteSize);
		// format iterations:salt:hash
		return iterations + ":" + toHex(salt) + ":" + toHex(hash);
	}

	
	public Boolean validateString(String password, String correctHash)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		return validatePassword(password.toCharArray(), correctHash);
	}
	
	/**
	 * Validates a password using a hash.
	 *
	 * @param  password the password to check
	 * @param  correctHash the hash of the valid password
	 * @return true if the password is correct, false if not
	 */
	private boolean validatePassword(char[] password, String correctHash)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Decode the hash into its parameters
		String [] params     = correctHash.split(":");
		int       iterations = Integer.parseInt(params[iterationIndex]);
		byte   [] salt       = fromHex(params[saltIndex]);
		byte   [] hash       = fromHex(params[hashIndex]);
		// Compute the hash of the provided password, using the same salt,
		// iteration count, and hash length
		byte   [] testHash   = pbkdf2(password, salt, iterations, hash.length);
		// Compare the hashes in constant time. The password is correct if
		// both hashes match.
		return slowEquals(hash, testHash);
	}

	/**
	 * Compares two byte arrays in length-constant time. This comparison method
	 * is used so that password hashes cannot be extracted from an on-line
	 * system using a timing attack and then attacked off-line.
	 * 
	 * @param  a the first byte array
	 * @param  b the second byte array
	 * @return true if both byte arrays are the same, false if not
	 */
	private boolean slowEquals(byte[] a, byte[] b) {
		int diff = a.length ^ b.length;
		for (int i = 0; i < a.length && i < b.length; i++){
			diff |= a[i] ^ b[i];
		}
			
		return diff == 0;
	}

	/**
	 * Computes the PBKDF2 hash of a password.
	 *
	 * @param  password the password to hash.
	 * @param  salt the salt
	 * @param  iterations the iteration count (slowness factor)
	 * @param  bytes the length of the hash to compute in bytes
	 * @return the PBDKF2 hash of the password
	 */
	private byte[] pbkdf2(char[] password, byte[] salt, int iterations,
			int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		PBEKeySpec       spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
		SecretKeyFactory skf  = SecretKeyFactory.getInstance(algorithm);
		
		return skf.generateSecret(spec).getEncoded();
	}

	/**
	 * Converts a string of hexadecimal characters into a byte array.
	 *
	 * @param  hex the hex string
	 * @return the hex string decoded into a byte array
	 */
	private byte[] fromHex(String hex) {
		byte [] binary = new byte[hex.length() / 2];
		
		for (int i = 0; i < binary.length; i++) {
			binary [i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return binary;
	}

	/**
	 * Converts a byte array into a hexadecimal string.
	 *
	 * @param  array the byte array to convert
	 * @return a length*2 character string encoding the byte array
	 */
	private String toHex(byte[] array) {
		BigInteger bi            = new BigInteger(1, array);
		String     hex           = bi.toString(16);
		int        paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0){
			return String.format("%0" + paddingLength + "d", 0) + hex;
		}else{
			return hex;
		}
	}

}
