package com.kzone.util;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.kzone.util.encryption.EncryptionUtil;
import com.kzone.util.encryption.HashUtil;
import com.kzone.util.encryption.annotation.Encrypt;
import com.kzone.util.encryption.annotation.Hash;

public class HibernateInterceptor implements Interceptor {

	@Autowired
	@Qualifier("objInterceptImpl")
	private ObjectInterceptor objectInterceptor;
	
	@Autowired
	@Qualifier("passwordHash")
	private HashUtil passHashUtil;
	
	@Autowired
	@Qualifier("encryption")
	private EncryptionUtil encryptionUtil;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HibernateInterceptor.class);
	
	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		
		for (int i = 0; i < propertyNames.length; i++) {
			
			Method getterForProperty = null;
			
			try {
				getterForProperty = objectInterceptor.getGetterForProperty(entity, propertyNames[i]);
				boolean encryptAnnotationPresent = getterForProperty.isAnnotationPresent(Encrypt.class);
				
				if(encryptAnnotationPresent){
					try {
						String encrypt = encryptionUtil.decrypt(state[i].toString());
						state[i] = encrypt;
						
					} catch (UnsupportedEncodingException | GeneralSecurityException e) {
						logger.error("Fail to decrypt the "+propertyNames[i] +" with the exception " + e);
						throw e;
					}
				}
				
			} catch ( IntrospectionException | UnsupportedEncodingException | GeneralSecurityException e1) {
				logger.error("Error when getting methods for "+propertyNames[i]+" : exception "+ e1);
			}
		}
		
		return false;
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {
		
		for (int i = 0; i < propertyNames.length; i++) {
			
			Method getterForProperty = null;
			
			try {
				getterForProperty = objectInterceptor.getGetterForProperty(entity, propertyNames[i]);
				
				boolean hashAnnotationPresent    = getterForProperty.isAnnotationPresent(Hash.class);
				boolean encryptAnnotationPresent = getterForProperty.isAnnotationPresent(Encrypt.class);
				
				if(encryptAnnotationPresent){
					try {
						String encrypt = encryptionUtil.encrypt(currentState[i].toString());
						currentState[i] = encrypt;
						
					} catch (UnsupportedEncodingException | GeneralSecurityException e) {
						logger.error("Fail to encrypt the "+propertyNames[i] +" with the exception " + e);
						throw e;
					}
					
				}else if(hashAnnotationPresent){
					String hash = null;
					try {
						hash = passHashUtil.createHash(currentState[i].toString());
						
					} catch (NoSuchAlgorithmException | InvalidKeySpecException hashException) {
						logger.error("Fail to hash the "+propertyNames[i] +" with the exception " + hashException);
					}
					currentState[i] = hash;
					
				}else if("modifiedDate".equals(propertyNames[i])){
					currentState[i] = new Timestamp(System.currentTimeMillis());
				}
				
			} catch (IntrospectionException | IllegalArgumentException | UnsupportedEncodingException | GeneralSecurityException  e1) {
				logger.error("Error for "+propertyNames[i]+" : exception "+ e1);
				throw new CallbackException(e1.getMessage(), e1);
			}
			
		}
		return true;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		
		for (int i = 0; i < propertyNames.length; i++) {
			
			Method getterForProperty = null;
			
			try {
				getterForProperty = objectInterceptor.getGetterForProperty(entity, propertyNames[i]);
				
				boolean hashAnnotationPresent    = getterForProperty.isAnnotationPresent(Hash.class);
				boolean encryptAnnotationPresent = getterForProperty.isAnnotationPresent(Encrypt.class);
				
				if(encryptAnnotationPresent){
					try {
						String encrypt = encryptionUtil.encrypt(state[i].toString());
						state[i] = encrypt;
						
					} catch (UnsupportedEncodingException | GeneralSecurityException e) {
						logger.error("Fail to encrypt the "+propertyNames[i] +" with the exception " + e);
						throw e;
					}
				}else if(hashAnnotationPresent){
					String hash = null;
					try {
						hash = passHashUtil.createHash(state[i].toString());
						
					} catch (NoSuchAlgorithmException | InvalidKeySpecException hashException) {
						logger.error("Fail to hash the "+propertyNames[i] +" with the exception " + hashException);
					}
					state[i] = hash;
					
				}else if("createdDate".equals(propertyNames[i])){
					state[i] = new Timestamp(System.currentTimeMillis());
					
				}else if("disabled".equals(propertyNames[i])){
					state[i] = Boolean.FALSE;
					
				}
				
			} catch (IntrospectionException | IllegalArgumentException | UnsupportedEncodingException | GeneralSecurityException e1) {
				logger.error("Error for "+propertyNames[i]+" : exception "+ e1);
				throw new CallbackException(e1.getMessage(), e1);
			}
		}
		
		return true;
	}

	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void onCollectionRecreate(Object collection, Serializable key)
			throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void onCollectionRemove(Object collection, Serializable key)
			throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void onCollectionUpdate(Object collection, Serializable key)
			throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void preFlush(Iterator entities) throws CallbackException {
		// TODO Auto-generated method stub

	}

	public void postFlush(Iterator entities) throws CallbackException {
		// TODO Auto-generated method stub

	}

	public Boolean isTransient(Object entity) {

//		if(entity instanceof BaseEntity){
//			BaseEntity baseEntity = (BaseEntity)entity;
//			return baseEntity.getId()== null;
//		}
		return null;
	}

	public int[] findDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub		
		return null;
	}

	public Object instantiate(String entityName, EntityMode entityMode,
			Serializable id) throws CallbackException {
		return null;
	}

	public String getEntityName(Object object) throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEntity(String entityName, Serializable id)
			throws CallbackException {
		// TODO Auto-generated method stub
		return null;
	}

	public void afterTransactionBegin(Transaction tx) {
		// TODO Auto-generated method stub

	}

	public void beforeTransactionCompletion(Transaction tx) {
		// TODO Auto-generated method stub

	}

	public void afterTransactionCompletion(Transaction tx) {
		// TODO Auto-generated method stub

	}

	public String onPrepareStatement(String sql) {
		// TODO Auto-generated method stub
		return sql;
	}

}
