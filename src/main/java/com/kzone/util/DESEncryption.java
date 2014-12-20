package com.kzone.util;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Singleton
public class DESEncryption implements EncryptionUtil {

	@Override
	public String encrypt(String rawString) {
		System.out.println("DESEncryption.encrypt()");
		return null;
	}

	@Override
	public String decrypt(String rawString) {
		System.out.println("DESEncryption.decrypt()");
		return null;
	}

}
