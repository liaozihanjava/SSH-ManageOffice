package com.elvis.office.service.common.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elvis.office.dao.ActionDao;
import com.elvis.office.dao.GroupsDao;
import com.elvis.office.dao.UserDao;
import com.elvis.office.pojo.Action;
import com.elvis.office.pojo.Groups;
import com.elvis.office.pojo.Role;
import com.elvis.office.pojo.User;
import com.elvis.office.service.common.UserServiceCommon;

@Service
public class UserServiceCommonImpl implements UserServiceCommon {

	@Resource
	private UserDao userDao;
	@Resource
	private GroupsDao groupsDao;
	@Resource
	private ActionDao actionDao;
	@Override
	public User login(String userid, String password) throws Exception {
		User retUser = new User();
		User pojo = userDao.findLogin(userid, password);
		if(pojo!=null){
			List<Groups> allGroups = this.groupsDao.findAllByRole(pojo.getRole().getRid());
			Iterator<Groups> iter = allGroups.iterator();
			while(iter.hasNext()){
				Groups gup = iter.next();
				Set<Action> set = new HashSet<Action>();
				set.addAll(actionDao.findAllByGroups(gup.getGid()));
				gup.setActions(set);
			}
			
			Set<Groups> groups = new TreeSet<Groups>();
			groups.addAll(allGroups);
			/*pojo.getRole().setGroupses(groups);*/
			Role role = new Role();
			role.setGroupses(groups);
			retUser.setRole(role);
			retUser.setLastlogin(pojo.getLastlogin());
			retUser.setLevel(pojo.getLevel());
			retUser.setName(pojo.getName());
			retUser.setUserid(pojo.getUserid());
			retUser.setPhoto(pojo.getPhoto());
			//更新当前时间
			pojo.setLastlogin(new Date());
			
			
		}
		return retUser;
	}

}
