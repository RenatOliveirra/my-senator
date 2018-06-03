package br.com.mysenator.example;

import javax.persistence.EntityManager;

import br.com.mysenator.dao.ApplicationManagedDAO;
import br.com.mysenator.model.Exemple;
import br.com.mysenator.util.JPAUtil;

public class ExempleFind {

	public static void main(String[] args) {
		//Find 
		EntityManager em = JPAUtil.getEntityManager();
		
		ApplicationManagedDAO managedDAO = new ApplicationManagedDAO(em);
		
		Exemple ex = managedDAO.findById(1, Exemple.class);
		
		System.out.println(ex.getName());
		
		
	}

}
