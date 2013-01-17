package com.zhao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zhao.server.IServer;
import com.zhao.util.ApplicationContextInstance;

public class AppMain {
	public static void main(String[] args) {
//		ApplicationContext ctx = new FileSystemXmlApplicationContext(
//				"conf/applicationContext.xml");
		IServer server = (IServer)ApplicationContextInstance.getInstance().getCtx().getBean("appServer");
		server.start();
	}
}
