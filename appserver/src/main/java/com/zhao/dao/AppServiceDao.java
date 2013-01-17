package com.zhao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhao.model.CatelogModel;
import com.zhao.model.CommonsModel;
import com.zhao.model.UserModel;

@Repository
public interface AppServiceDao {

//	 public void insertUser(CommonsModel user);
//	
//	 public UserModel getUserById(Integer userId);
//	 
//	 public List<UserModel> getAllUsers();
//	 
//	 public void updateUser(UserModel user);
//	 
//	 public void deleteUser(Integer userId);
	
	 List<CommonsModel> queryAuctionByCatelog(String specialCode);
	 
	 List<CommonsModel> queryAllCatelogInfo();
}
