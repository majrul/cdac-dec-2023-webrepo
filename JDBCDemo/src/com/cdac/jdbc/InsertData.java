package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			Statement stmt = conn.createStatement();
			String sql = "insert into tbl_product (name, price, quantity) values ('Realme 11 Pro', 39000, 25)";
			stmt.executeUpdate(sql); //DML
			System.out.println("record inserted..");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}		
		
	}
}
