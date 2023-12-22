package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.cj.jdbc.Driver;

public class DBInfo {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Driver d = new Driver();
			//Establish Connection with the Database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			System.out.println("yayy, got connected!");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Please check the no. of your glasses O-O");
		}
		catch(SQLException e) {
			System.out.println("Something wrong with MySQL!");
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
