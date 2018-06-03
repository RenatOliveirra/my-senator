package br.com.mysenator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Exemple extends AbstractModel{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String name;
	
	private String politicFunction;
	
	@Override
	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliticFunction() {
		return this.politicFunction;
	}

	public void setPoliticFunction(String politicFunction) {
		this.politicFunction = politicFunction;
	}
	

}
