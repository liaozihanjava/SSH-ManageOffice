package com.elvis.office.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elvis.office.dao.UserDao;
import com.elvis.office.pojo.User;
import com.elvis.util.dao.AbstractDaoImpl;

@Component
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	@Override
	public boolean doCreate(User vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(User vo) throws SQLException {
		String hql = "Update User as u set u.name=?,u.phone=?,u.email=?,u.photo=? where u.userid=?";
		Query query = super.getQuery(hql);
		query.setParameter(0, vo.getName());
		query.setParameter(1, vo.getPhone());
		query.setParameter(2, vo.getEmail());
		query.setParameter(3, vo.getPhoto());
		query.setParameter(4, vo.getUserid());
		
		return query.executeUpdate() > 0;
		
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(String id) throws SQLException {
		return (User)super.getSession().get(User.class, id);
	}

	@Override
	public List<User> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
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
	public User findLogin(String userid, String password) throws Exception {
		String hql = "FROM User AS u WHERE u.userid=? AND u.password=?";
		Query query = super.getQuery(hql);
		query.setParameter(0, userid);
		query.setParameter(1, password);
		return (User) query.uniqueResult();
	}

	@Override
	public boolean doUpdatePassword(User vo) throws Exception {
		String hql = "update User as u set u.password=? where u.userid=?";
		Query query = super.getQuery(hql);
		query.setParameter(0, vo.getPassword());
		query.setParameter(1, vo.getUserid());
		return query.executeUpdate() > 0;
	}

}
