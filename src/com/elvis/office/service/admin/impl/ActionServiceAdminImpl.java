package com.elvis.office.service.admin.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elvis.office.dao.ActionDao;
import com.elvis.office.pojo.Action;
import com.elvis.office.service.admin.ActionServiceAdmin;


@Service
public class ActionServiceAdminImpl implements ActionServiceAdmin {

	@Resource
	private ActionDao actionDao;
	
	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("allActions",this.actionDao.findAllSplit(currentPage, lineSize, column, keyWord) );
		map.put("actionCount", this.actionDao.getAllCount(column, keyWord));
		System.out.println(this.actionDao.getAllCount(column, keyWord));
		return map;
	}

	@Override
	public boolean update(Action vo) throws Exception {
		return this.actionDao.doUpdate(vo);
	}

}
