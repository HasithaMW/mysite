package com.kzone.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Singleton
public class ObjectInterceptorImpl implements ObjectInterceptor {

	@Override
	public Class<?> getClass(Object object) {
		return object.getClass();
	}

	public List<Method> getMethods(Object object) {
		Method[] methods = getClass(object).getMethods();
		return Arrays.asList(methods);
	}

	private Boolean isAGetter(Method method) {

		if (!method.getName().startsWith("get")) {
			return false;
		} else if (method.getParameterTypes().length != 0) {
			return false;
		} else if (void.class.equals(method.getReturnType())) {
			return false;
		}
		return true;
	}

	@Override
	public List<Method> getGetters(Object object) {
		List<Method> methodList = new LinkedList<Method>();
		List<Method> methods    = getMethods(object);

		for (Method method : methods) {
			if (isAGetter(method)) {
				methodList.add(method);
			}
		}

		return methodList;
	}

	private Boolean isASetter(Method method) {

		if (!method.getName().startsWith("set")) {
			return false;
		} else if (method.getParameterTypes().length != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Method> getSetters(Object object) {
		List<Method> methodList = new LinkedList<Method>();
		List<Method> methods    = getMethods(object);

		for (Method method : methods) {
			if (isASetter(method)) {
				methodList.add(method);
			}
		}

		return methodList;
	}

	
	public Method getGetterForProperty(Object object,String property) throws IntrospectionException{
		
		String output = property.substring(0, 1).toUpperCase() + property.substring(1);
		
		Class<?> class1 = getClass(object);
		
		for(PropertyDescriptor propertyDescriptor : 
		    Introspector.getBeanInfo(class1).getPropertyDescriptors()){

			Method method = propertyDescriptor.getReadMethod();
			if(method != null){
				String methodName   = method.getName();
				
				if(methodName.contains(output)){
					return method;
				}
			}
			
		}
		return null;
	}
	
	public Method getSetterForProperty(Object object,String property) throws IntrospectionException{
		
		String output = property.substring(0, 1).toUpperCase() + property.substring(1);
		
		for(PropertyDescriptor propertyDescriptor : 
		    Introspector.getBeanInfo(getClass(object)).getPropertyDescriptors()){

			Method method = propertyDescriptor.getWriteMethod();
			if(method != null){
				String methodName   = method.getName();
				
				if(methodName.contains(output)){
					return method;
				}
			}
		}
		return null;
	}
	
	
	@Override
	public List<Method> getMethodsAnnotatedWith(Annotation annoation,Object object) {
		List<Method> methodList = new LinkedList<Method>();
		List<Method> methods    = getMethods(object);

		for (Method method : methods) {
			if(method.isAnnotationPresent(annoation.getClass())){
				methodList.add(method);
			}
		}
		
		return methodList;
	}

	
	@Override
	public Object invokeMethod(Object object, Method method, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return method.invoke(object, args);
	}

}
