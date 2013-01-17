package com.zhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zhao.dao.AppServiceDao;
import com.zhao.model.CatelogModel;
import com.zhao.model.CommonsModel;
import com.zhao.model.UserModel;
import com.zhao.service.AppService;

@Service(value="AppServiceImpl")
@Transactional
public class AppServiceImpl implements AppService {
	
	@Autowired
	private AppServiceDao appServiceDao;
	public String doSelect(String params) {
		return "文鑫";
	}

	public String doSave(String params) {
		UserModel model = new UserModel();
		model.setAddress("新抚钢");
		model.setAge(29);
		model.setCode("wangyuxin");
		model.setName(params);

		return JSON.toJSONString(model);
	}

	public void insertUser(String user) {
		CommonsModel u = JSON.parseObject(user,new TypeReference<CommonsModel>(){});
//		System.out.println("==========="+this.appServiceDao);
//		CommonsModel us = new CommonsModel();
//		us.setEmailId("test_mail111unxiao@gmail.com");
//	    us.setPassword("secre11t");
//	    us.setFirstName("TestFirstName111");
//	    us.setLastName("TestLastName222");
//		this.appServiceDao.insertUser(u);
//		this.appServiceDao.deleteUser(10);
//		String a = null;
//		System.out.println(a.toString());
//		try{
//			System.out.println(a.toString());	
//		}catch(Exception e){
//			
//		}
		
//		this.appServiceDao.deleteUser(9);
//		System.out.println("============execu=====insertUser");
	}

	@Transactional(readOnly=true)
	public UserModel getUserById(Integer userId) {
		return null;
	}

	@Transactional(readOnly=true)
	public List<UserModel> getAllUsers() {
		return null;
	}

	public void updateUser(UserModel user) {
		
	}

	public void deleteUser(Integer userId) {
//		this.appServiceDao.deleteUser(userId);
	}

	public String queryAllCatelogInfo() {
		return JSON.toJSONString(this.appServiceDao.queryAllCatelogInfo());
	}

	public String queryAuctionByCatelog(String specialCode) {
		return JSON.toJSONString(this.appServiceDao.queryAuctionByCatelog(specialCode));
	}
}
