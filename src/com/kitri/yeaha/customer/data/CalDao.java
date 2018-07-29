package com.kitri.yeaha.customer.data;

import java.sql.*;

public class CalDao {

	public Connection getDbCon() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.12.15:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			con = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}// getDbCon() 종료지점

}
