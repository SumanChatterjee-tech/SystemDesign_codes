package com.home.ObjectPoolPattern_Creational;

import java.util.*;

public class DbConnectionPoolManager { //we have to make this class as singleton

	private List<DBConnection> freeConnectionPool = new ArrayList<>();
	private List<DBConnection> CurrentlyUseConnectionPool = new ArrayList<>();
	private static final int INT_POOL_SIZE = 3;
	private static final int MAX_POOL_SIZE = 6;
	
	private static DbConnectionPoolManager dbConnectionPoolManagerInstance = null;
	
	private DbConnectionPoolManager() {
		for(int i=0;i<INT_POOL_SIZE;i++) {
			freeConnectionPool.add(new DBConnection());
		}
	}
	
	public static DbConnectionPoolManager getInstance() {
		if(dbConnectionPoolManagerInstance == null) {
			synchronized (DbConnectionPoolManager.class) {
				if(dbConnectionPoolManagerInstance == null) {
					dbConnectionPoolManagerInstance = new DbConnectionPoolManager();
				}
			}
		}
		return dbConnectionPoolManagerInstance;
	}
	
	public synchronized DBConnection getConnection() {
		if(freeConnectionPool.isEmpty() && CurrentlyUseConnectionPool.size() < MAX_POOL_SIZE) { //I still can create new conn
			System.out.println("Can create more connections");
			freeConnectionPool.add(new DBConnection());
		}else if(freeConnectionPool.isEmpty() && CurrentlyUseConnectionPool.size() >= MAX_POOL_SIZE) { //I can not create new conn
			System.out.println("Can not create more connections");
			return null;
		}
		
		//I will now remove one connection from freepool and add the removed connection to usepool
		DBConnection dbConnection =  freeConnectionPool.remove(freeConnectionPool.size()-1); //remove from last
		CurrentlyUseConnectionPool.add(dbConnection);
		return dbConnection;
		
	}
	
	public synchronized void releaseConnection(DBConnection dbConnection) {
		if(dbConnection != null) {
			System.out.println("Removing the connection from use pool");
			CurrentlyUseConnectionPool.remove(dbConnection); //remove from usedpool
			System.out.println("Added the connection to free pool");
			freeConnectionPool.add(dbConnection); //add the connection to the free pool
		}
	}
	
	
}
