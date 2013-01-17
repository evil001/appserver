package com.zhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.zhao.dao.CatelogServiceDao;

@Service
@Transactional
public class CatelogServiceImpl {

	@Autowired
	private CatelogServiceDao catelogServiceDao;
	public String queryAllCatelog(){
		return JSON.toJSONString(this.catelogServiceDao.queryAllCatelogInfo());
	}
}
