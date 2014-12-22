package com.kzone.util;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.kzone.util.encryption.annotation.Hash;

public class HibernateInterceptor implements Interceptor {

	@Autowired
	private ObjectInterceptor objectInterceptor;
	
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {
		
		for (int i = 0; i < propertyNames.length; i++) {
			if("modifiedDate".equals(propertyNames[i])){
				currentState[i] = new Timestamp(System.currentTimeMillis());
				return true;
			}
		}
		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		
		for (int i = 0; i < propertyNames.length; i++) {
			if("createdDate".equals(propertyNames[i])){
				state[i] = new Timestamp(System.currentTimeMillis());
			}else if("disabled".equals(propertyNames[i])){
				state[i] = Boolean.FALSE;
			}
			
			try {
				Method getterForProperty = objectInterceptor.getGetterForProperty(entity, propertyNames[i]);
				Method setterForProperty = objectInterceptor.getSetterForProperty(entity, propertyNames[i]);
				boolean annotationPresent = getterForProperty.isAnnotationPresent(Hash.class);
				if(annotationPresent){
					System.out.println("Hash annotationPresent :" + annotationPresent);
					System.out.println("method  :" + getterForProperty);
				}
				
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
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
//			if(baseEntity.getId()== null){
//				baseEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//				baseEntity.setDisabled(Boolean.FALSE);
//				return true;
//			}
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
