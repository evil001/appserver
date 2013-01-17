package com.zhao.factory;

import java.lang.reflect.Method;

import com.zhao.model.RequestModel;
import com.zhao.service.AppService;
import com.zhao.service.impl.AppServiceImpl;
import com.zhao.util.ApplicationContextInstance;

public class AppFactory {
	public RequestModel model;

	public AppFactory(RequestModel model) {
		this.model = model;
	}

	public String getMessage() {
		String result = "";
		if (model.getParameter() == ""||null==model.getParameter()) {
			try {
				result = doMethod().toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				result = doMethodWithParams(model.getParameter()).toString();
//				doMethod(model.getParameter().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Object doMethodWithParams(String params) throws Exception {
		Object obj = null;
		try{
//			Class<?> cls = Class
//					.forName("com.zhao.service.impl." + model.getClassName());
//			Method method = cls.getMethod(model.getMethodName(), String.class);
//			obj = method.invoke(cls.newInstance(), params);
			AppService app =  (AppService)ApplicationContextInstance.getInstance().getCtx().getBean(model.getClassName());
			obj = app.queryAuctionByCatelog(params);
			System.out.println("========="+obj);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	public Object doMethod() throws Exception {
		Object obj = null;
		try{
//			Class<?> cls = Class
//					.forName("com.zhao.service.impl." + model.getClassName());
//			Method method = cls.getMethod(model.getMethodName(), String.class);
//			obj = method.invoke(cls.newInstance(), null);
			AppService app =  (AppService)ApplicationContextInstance.getInstance().getCtx().getBean(model.getClassName());
			obj = app.queryAllCatelogInfo();
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
	
	public void doMethod(String params) throws Exception{
////		Class<?> cls = Class
////				.forName("com.zhao.service.impl." + model.getClassName());
//		Class<?> cls = (Class<?>) ApplicationContextInstance.getInstance().getCtx().getBean(model.getClassName());
//		Method method = cls.getMethod(model.getMethodName());
//		method.invoke(cls.newInstance(), params);
		AppService app =  (AppService)ApplicationContextInstance.getInstance().getCtx().getBean(model.getClassName());
		System.out.println("=============="+ApplicationContextInstance.getInstance().getCtx().getBean(model.getClassName()).getClass());
		
		app.insertUser(params);
	}
}
