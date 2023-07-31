package com.dreamRealty.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DreamRealtyDAO {
	static final String DB_URL = "urlOfDB";
	static final String USER = "user";
	static final String PASS = "password";
	
	public Connection createConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
