package com.zhao.util;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

public class ApplicationContextInstance{

	public static ApplicationContextInstance instance = new ApplicationContextInstance();
	
	public static ApplicationContext ctx ;
	
	public ApplicationContextInstance() {
		ctx = new FileSystemXmlApplicationContext(
				"conf/applicationContext.xml");
	}

	public static ApplicationContextInstance getInstance(){
		return instance;
	}
	
	public ApplicationContext getCtx(){
		return ctx;
	}
}