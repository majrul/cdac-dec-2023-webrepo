package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.cj.jdbc.Driver;

public class FetchData {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			String sql = "select * from tbl_product where price >= ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter price based on which products will be displayed");
			double basePrice = s.nextDouble();
			
			stmt.setDouble(1, basePrice); //substituting ? with the actual data
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int quantity = rs.getInt(4);
				System.out.println(id + " , " + name + " , " + price + " , " + quantity);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
