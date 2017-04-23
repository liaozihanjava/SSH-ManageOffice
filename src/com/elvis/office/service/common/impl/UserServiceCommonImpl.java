package com.elvis.office.service.common.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elvis.office.dao.UserDao;
import com.elvis.office.pojo.User;
import com.elvis.office.service.common.UserServiceCommon;

@Service
public class UserServiceCommonImpl implements UserServiceCommon {

	@Resource
	private UserDao userDao;
	
	@Override
	public User login(String userid, String password) throws Exception {
		
		return userDao.findLogin(userid, password);
	}

}
