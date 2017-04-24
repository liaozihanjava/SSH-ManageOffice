package com.elvis.office.dao;

import java.util.List;

import com.elvis.office.pojo.Groups;
import com.elvis.util.dao.IDAO;

public interface GroupsDao extends IDAO<Integer,Groups>{

	
	public List<Groups> findAllByRole(Integer rid) throws Exception;
}
