package com.home.ObjectPoolPattern_Creational;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	Connection dBConnection;

	public DBConnection() {
		try {
			this.dBConnection = DriverManager.getConnection("url", "user", "password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	
	
}
