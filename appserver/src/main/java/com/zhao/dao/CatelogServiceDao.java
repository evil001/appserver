package com.zhao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhao.model.CatelogModel;

@Repository
public interface CatelogServiceDao {

	List<CatelogModel> queryAllCatelogInfo();
}
