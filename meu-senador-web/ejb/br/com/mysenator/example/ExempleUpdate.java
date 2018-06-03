package br.com.mysenator.example;

import javax.persistence.EntityManager;

import br.com.mysenator.dao.ApplicationManagedDAO;
import br.com.mysenator.model.Exemple;
import br.com.mysenator.util.JPAUtil;

public class ExempleUpdate {
	

	
	public static void main(String[] args) {
		
		//Find and/or Update
		EntityManager em = JPAUtil.getEntityManager();

		ApplicationManagedDAO managedDAO = new ApplicationManagedDAO(em);
		
		Exemple ex = managedDAO.findById(2, Exemple.class);
		ex.setName("Dilmãe");		
		managedDAO.update(ex);
	}

}
