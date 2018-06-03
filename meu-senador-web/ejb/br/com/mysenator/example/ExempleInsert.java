package br.com.mysenator.example;

import javax.persistence.EntityManager;

import br.com.mysenator.dao.ApplicationManagedDAO;
import br.com.mysenator.model.Exemple;
import br.com.mysenator.util.JPAUtil;

public class ExempleInsert {
	

	
	public static void main(String[] args) {
		Exemple ex = new Exemple();
		ex.setName("Dilma Roussef");
		ex.setPoliticFunction("Ex-Presidente");
		
		//Create and/or Insert
		EntityManager em = JPAUtil.getEntityManager();

		ApplicationManagedDAO managedDAO = new ApplicationManagedDAO(em);
		
		managedDAO.insert(ex);
//		
//	
//		
		
	}

}
