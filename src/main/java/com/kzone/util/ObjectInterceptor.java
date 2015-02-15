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

	/**
	 * Get the Class object of this {@code object}
	 * @param object object to get the Class Object
	 * @return the Class object 
	 */
	public Class<?> getClass(Object object);
	
	/**
	 * Will get all the methods of the Class associates with this object
	 * 
	 * @param object to get {@code Methods}
	 * @return list of methods 
	 */
	public List<Method> getMethods(Object object);
	
	
	/**
	 * Will get all the getter methods of the Class associates with this object
	 * 
	 * @param object to get  all getter methods
	 * @return list of getter methods
	 */
	public List<Method> getGetters(Object object);
	
	/**
	 * Will get all the setter methods of the Class associates with this object
	 * 
	 * @param object
	 * @return
	 */
	public List<Method> getSetters(Object object);
	
	/**
	 * will return the getter method for the given property.
	 * @param object to inspect
	 * @param property name of the property
	 * @return the getter method for the property
	 * @throws IntrospectionException
	 */
	public Method getGetterForProperty(Object object,String property) throws IntrospectionException;
	
	/**
	 * will return setter method for the given property 
	 * @param object to inspect
	 * @param property name of the property
	 * @return the setter method for the proprty
	 * @throws IntrospectionException
	 */
	public Method getSetterForProperty(Object object,String property) throws IntrospectionException;
	
	/**
	 * will return all the methods that are <b>annotated</b> with the given <i>Annotations</i>
	 * @param annoation that must appear in the methods
	 * @param object to inspect
	 * @return list of methods 
	 */
	public List<Method> getMethodsAnnotatedWith(Annotation  annoation,Object object);
	
	/**
	 * will invoke the given <i>method</i> from the given <i>object</i>
	 * if method is a no argument, then <i>args</i> is null.
	 * @param object to invoke method from
	 * @param method method to invoke
	 * @param args for the method.
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object invokeMethod(Object object,Method method,Object... args)throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	
}
