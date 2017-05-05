package com.elvis.office.service.admin;

import java.util.Map;

import com.elvis.office.pojo.Action;

public interface ActionServiceAdmin {
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception;
	public boolean update(Action vo) throws Exception;
}
