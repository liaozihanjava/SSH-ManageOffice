package com.elvis.office.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.elvis.office.dao.ActionDao;
import com.elvis.office.pojo.Action;
import com.elvis.util.dao.AbstractDaoImpl;

@Component
public class AcionDaoImpl extends AbstractDaoImpl implements ActionDao {

	@Override
	public boolean doCreate(Action vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Action vo) throws SQLException {
		String hql = "update Action as a set a.title=?,a.url=? where a.actid=?";
		Query query = super.getQuery(hql);
		query.setParameter(0, vo.getTitle());
		query.setParameter(1, vo.getUrl());
		query.setParameter(2, vo.getActid());
		return query.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Action findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Action> findAll() throws SQLException {
		return super.handleList(Action.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Action> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		return super.handleSplit(Action.class, currentPage, lineSize, column, keyWord);
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return super.handleCount("Action", column, keyWord);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Action> findAllByGroups(Integer gid) throws Exception {
		String hql = "from Action as a where a.groups.gid = ?";
		Query query = (Query) super.getQuery(hql);
		query.setParameter(0, gid);
		return query.list();
	}

}
