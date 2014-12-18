package com.kzone.config;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class HibernateInterceptor implements Interceptor {

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
			}else if ("disabled".equals(propertyNames[i])){
				state[i] = Boolean.FALSE;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
