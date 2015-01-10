package com.kzone.util.encryption;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Singleton;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Singleton
@PropertySource(value = { "classpath:security.properties" })
public class AESEncryption implements EncryptionUtil {

	private static final  Logger logger = LoggerFactory.getLogger(AESEncryption.class);
	static{
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}
	
	@Autowired
	private Environment   environment;
	private SecretKeySpec key          = null; 
	private Cipher        cipher       = null;
	

	@PostConstruct
	private void passwordHash() throws GeneralSecurityException, UnsupportedEncodingException{
		
		String stringKeay = environment.getRequiredProperty("aes.key");
		
		assert stringKeay != null : "AES key is null! Please set add the aes.key to security.properties";  
		
		byte[] bytes      = stringKeay.getBytes("UTF-8");
		int    length     = bytes.length;
		
		assert length == 16 || length == 24 || length == 32 : "Key length not 16/24/32 bits";  
		
		key = new SecretKeySpec(bytes, "AES");
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		
	}
	
	@Override
	public String encrypt(String rawString) throws GeneralSecurityException, UnsupportedEncodingException {
		
		assert rawString != null : "rawString is null!! give a value to encrypt";  
		
		try {
			
			cipher.init(Cipher.ENCRYPT_MODE, key);
		    return Base64.encodeBase64String(cipher.doFinal(rawString.getBytes("UTF-8")));
		    
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public String decrypt(String encryptedString) throws GeneralSecurityException, UnsupportedEncodingException {
		
		assert encryptedString != null : "encryptedString is null!! give a value to decrypt";  

		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			
			byte[] plainText = cipher.doFinal(Base64.decodeBase64(encryptedString));
		    
		    return new String(plainText,"UTF-8");
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	    
	}
	
}
