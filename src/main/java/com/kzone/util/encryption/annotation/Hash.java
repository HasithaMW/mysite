package com.kzone.util.encryption.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface Hash {

//	String algorithm()    default "PBKDF2WithHmacSHA1";
//	int    saltByteSize() default 24;
//	int    hashByteSize() default 24;
//
//	Class<? extends HashUtil> classToUse() default PasswordHash.class;
}
