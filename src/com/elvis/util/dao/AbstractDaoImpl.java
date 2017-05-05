package com.elvis.util.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
/**
 * 这个类作为DAO子类的公共父类，目的是简化重复代码的开发
 * @author mldn
 */
public abstract class AbstractDaoImpl {
	@Resource
	private SessionFactory sessionFactory ;
	/**
	 * 设置SessionFactory类对象，是在子类构造方法注入的时候自动完成调用
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 返回SessionFactory，一般只有在操作二级缓存的时候才会执行此操作
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * 负责提供当前可用的Session对象
	 * @return
	 */
	public Session getSession() {
		return this.sessionFactory.getCurrentSession() ;
	}
	/**
	 * 利用此方法可以取得Query对象
	 * @param hql 要执行的HQL语句
	 * @return
	 */
	public Query getQuery(String hql) {
		return this.getSession().createQuery(hql) ;
	}
	
	public Query getSqlQuery(String sql){
		return this.getSession().createSQLQuery(sql);
	}
	/**
	 * 利用此方法取得Criteria对象
	 * @param cls 操作的类型
	 * @return
	 */
	public Criteria getCriteria(Class<?> cls) {
		Criteria criteria = this.getSession().createCriteria(cls) ;
		return criteria ;
	} 
	
	public Integer handleCount(String pojoName, String column, String keyWord) {
		System.out.println("keyWord:"+keyWord);
		String hql = "SELECT COUNT(*) FROM " + pojoName + " AS p WHERE p."
				+ column + " LIKE ?";
		Query query = this.getQuery(hql);
		query.setParameter(0, "%" + keyWord + "%");
		System.out.println("Dao:"+((Long) query.uniqueResult()).intValue());
		return ((Long) query.uniqueResult()).intValue();
	}
	@SuppressWarnings("rawtypes")
	public List handleSplit(Class<?> cls,Integer currentPage,Integer lineSize,String column,String keyWord){
		Criteria criteria = this.getCriteria(cls);
		criteria.add(Restrictions.like(column, "%"+keyWord+"%"));
		criteria.setFirstResult((currentPage-1)*lineSize);
		criteria.setMaxResults(lineSize);
		return criteria.list();
	}
	@SuppressWarnings("rawtypes")
	public List handleList(Class<?> cls){
		Criteria criteria = this.getCriteria(cls);
		return criteria.list();
	}
}
