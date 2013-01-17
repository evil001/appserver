package com.zhao.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.zhao.model.CommonsModel;
import com.zhao.model.RequestModel;
import com.zhao.model.UserModel;

public class JsonTest {
	public static void main(String[] args) {
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		RequestModel model = new RequestModel();
//		UserModel user = new UserModel();
//		user.setEmailId("test_mail"+System.currentTimeMillis()+"@gmail.com");
//	    user.setPassword("secret");
//	    user.setFirstName("TestFirstName");
//	    user.setLastName("TestLastName");
//		model.setClassName("AppServiceImpl");
//		model.setMethodName("insertUser");
//		model.setParameter(JSON.toJSONString(user));
//		CommonsModel u = JSON.parseObject(JSON.toJSONString(user),new TypeReference<CommonsModel>(){});
//		System.out.println("======"+u.getPassword());
		model.setClassName("AppServiceImpl");
		model.setMethodName("queryAllCatelogInfo");
		String result = JSON.toJSONString(model, filter);
		System.out.println(result);
	}
}
