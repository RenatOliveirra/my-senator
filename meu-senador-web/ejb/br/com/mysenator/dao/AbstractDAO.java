package br.com.mysenator.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.mysenator.model.AbstractModel;
import br.com.mysenator.sqlbuilder.ISqlBuilder;

/**
 * This abstract class must to encapsulate the most complex logical for acess a object from database.
 *@author Renato Oliveira 
 *@since 02/06/2018
 **/

public abstract class AbstractDAO {
	
	public abstract EntityManager getEntityManager();	
	
	public <E extends AbstractModel> E findById(Integer id, Class<E> entityClass){
		return this.getEntityManager().find(entityClass, id);
	}
	
	public void insert(AbstractModel entity){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entity);
		this.getEntityManager().getTransaction().commit();
	}
	
	public void update(AbstractModel entity){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entity);
		this.getEntityManager().getTransaction().commit();
	}
	
	protected <E extends AbstractModel> void delete(Integer id, Class<E> entityClass){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(this.findById(id, entityClass));
		this.getEntityManager().getTransaction().commit();
	}
	
	/**
	 *GET RESULT FROM A SELECT QUERY 
	 **/
	@SuppressWarnings("rawtypes")
	public List executeNativeQuery(ISqlBuilder sqlBuilder){
		Session session = this.getEntityManager().unwrap(Session.class);
		
		SQLQuery query = session.createSQLQuery(sqlBuilder.buildSql());
		
		sqlBuilder.prepareQuery(query);
		
		return query.list();
	}
	
	/**
	 *INSERT/UPDATE/DELETE 
	 **/
	public void executeNativeSql(ISqlBuilder sqlBuilder){
		Session session = this.getEntityManager().unwrap(Session.class);
		
		SQLQuery query = session.createSQLQuery(sqlBuilder.buildSql());
		
		sqlBuilder.prepareQuery(query);
		
		query.executeUpdate();
	}
}
