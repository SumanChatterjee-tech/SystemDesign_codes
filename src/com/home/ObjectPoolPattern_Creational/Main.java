package com.home.ObjectPoolPattern_Creational;

public class Main {

	public static void main(String[] args) {
		DbConnectionPoolManager poolManager = new DbConnectionPoolManager();
		DBConnection dbc1 = poolManager.getConnection();
		DBConnection dbc2 = poolManager.getConnection();
		DBConnection dbc3 = poolManager.getConnection();
		DBConnection dbc4 = poolManager.getConnection();
		DBConnection dbc5 = poolManager.getConnection();
		DBConnection dbc6 = poolManager.getConnection();
		DBConnection dbc7 = poolManager.getConnection();
		System.out.println(dbc7); //it should be null
		poolManager.releaseConnection(dbc6);

	}

}
