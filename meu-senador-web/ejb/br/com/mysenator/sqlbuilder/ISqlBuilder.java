package br.com.mysenator.sqlbuilder;

import org.hibernate.SQLQuery;

public interface ISqlBuilder {
	
	String buildSql();
	
	void prepareQuery(SQLQuery query);

}
