package br.com.mysenator.example;

import javax.persistence.EntityManager;

import br.com.mysenator.model.Exemple;
import br.com.mysenator.util.JPAUtil;

public class ExempleInsert {
	

	
	public static void main(String[] args) {
		Exemple ex = new Exemple();
		ex.setName("Lula da Silva");
		ex.setPoliticFunction("Ex-Presidente");
		
		//Create and/or Insert
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(ex);
		em.getTransaction().commit();
		
		em.close();
		
		
	}

}
