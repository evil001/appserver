package com.zhao.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhao.model.CatelogModel;
import com.zhao.model.CommonsModel;
import com.zhao.model.UserModel;

public interface AppService {

	 public void insertUser(String user);
	
	 public UserModel getUserById(Integer userId);
	 
	 public List<UserModel> getAllUsers();
	 
	 public void updateUser(UserModel user);
	 
	 public void deleteUser(Integer userId);
	 
	 String queryAllCatelogInfo();
	 
	 String queryAuctionByCatelog(String specialCode);
}
