package com.chainsys.reservemeapp.adminrole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestListTrains {
	public static Connection connect() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		String server = "13.235.147.120";
		//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "aravinth","aravinth");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println(connection);
		return connection;

	}
}
