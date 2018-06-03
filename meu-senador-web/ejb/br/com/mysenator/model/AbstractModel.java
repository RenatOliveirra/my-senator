package br.com.mysenator.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractModel {
	
	public abstract Integer getId();
	
	public String toString(){
		return this.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this)) + "[id="+
				this.getId() + "]";
	}

}
