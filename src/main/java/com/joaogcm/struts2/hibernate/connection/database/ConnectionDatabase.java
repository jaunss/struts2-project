package com.joaogcm.struts2.hibernate.connection.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {

	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/struts2_project";
	private static final String USER = "root";
	private static final String PASSWORD = "Joao09011997!";

	public Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}