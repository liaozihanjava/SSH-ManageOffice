package com.elvis.office.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Component;

import com.elvis.office.dao.GroupsDao;
import com.elvis.office.pojo.Groups;
import com.elvis.util.dao.AbstractDaoImpl;

@Component
public class GroupsDaoImpl extends AbstractDaoImpl implements GroupsDao {

	@Override
	public boolean doCreate(Groups vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Groups vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Groups findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> findAllByRole(Integer rid) throws Exception {
		String sql = "select gid,title,note from groups where gid in ("
				+ "select gid from role_groups where rid = ?)";
		
		Query query = super.getSqlQuery(sql);
		query.setResultTransformer(new AliasToBeanResultTransformer(Groups.class));
		query.setParameter(0,rid);
		
		return query.list();
	}

}
