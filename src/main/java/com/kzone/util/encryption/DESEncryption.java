package com.kzone.util.encryption;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Singleton
@PropertySource(value = { "classpath:resources.properties" })
public class DESEncryption implements EncryptionUtil {

	@Autowired
	private Environment environment;
	
	@Override
	public String encrypt(String rawString) {
		return null;
	}

	@Override
	public String decrypt(String rawString) {
		return null;
	}

}
