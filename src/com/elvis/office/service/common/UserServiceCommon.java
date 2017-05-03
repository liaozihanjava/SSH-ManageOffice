package com.elvis.office.service.common;

import com.elvis.office.pojo.User;

public interface UserServiceCommon {
public User login(String userid,String password) throws Exception;
public boolean updatePassword(String userid,String oldPassword,String newPassword) throws Exception;
public User updatePre(String userid) throws Exception;
public boolean update(User vo) throws Exception;
}
