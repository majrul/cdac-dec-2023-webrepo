package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData4 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			String sql = "insert into tbl_product (name, price, quantity) values (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			//substituting ? with actual data
			stmt.setString(1, "Motorola Razr 40");
			stmt.setDouble(2, 49000);
			stmt.setInt(3, 45);
			stmt.executeUpdate();
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
