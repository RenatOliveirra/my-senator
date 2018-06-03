package br.com.mysenator.dao;

import javax.persistence.EntityManager;

import br.com.mysenator.util.JPAUtil;

/**
 * This class is the responsible to manage the Data Access Object (DAO) into application level.
 *@author Renato Oliveira 
 *@since 02/06/2018
 **/
public class ApplicationManagedDAO extends AbstractDAO{
	
	private EntityManager entityManager;
	
	public ApplicationManagedDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public EntityManager getEntityManager() {
		if(this.entityManager == null){
			this.entityManager = JPAUtil.getEntityManager();
		}
		
		return this.entityManager;
	}
}
