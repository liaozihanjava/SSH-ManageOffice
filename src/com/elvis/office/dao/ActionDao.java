package com.elvis.office.dao;

import java.util.List;

import com.elvis.office.pojo.Action;
import com.elvis.util.dao.IDAO;

public interface ActionDao extends IDAO<Integer, Action> {
	public List<Action> findAllByGroups(Integer gid) throws Exception;
}
