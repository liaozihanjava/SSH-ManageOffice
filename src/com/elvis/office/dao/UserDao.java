package com.elvis.office.dao;

import com.elvis.office.pojo.User;
import com.elvis.util.dao.IDAO;

public interface UserDao extends IDAO<String, User> {
	public User findLogin(String userid, String password) throws Exception;
}
