package com.kzone.util;

import java.beans.IntrospectionException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * This interface use to intercept Objects.
 * @author kasun
 * @version 1.0.1
 */
public interface ObjectInterceptor {

	public Class<?> getClass(Object object);
	
	public List<Method> getMethods(Object object);
	
	public List<Method> getGetters(Object object);
	
	public List<Method> getSetters(Object object);
	
	public Method getGetterForProperty(Object object,String property) throws IntrospectionException;
	
	public Method getSetterForProperty(Object object,String property) throws IntrospectionException;
	
	public List<Method> getMethodsAnnotatedWith(Annotation  annoation,Object object);
	
	public Object invokeMethod(Object object,Method method,Object... args)throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	
}
