package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData3 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			//System.out.println(conn.getClass());
			Statement stmt = conn.createStatement();
			//System.out.println(stmt.getClass());
			//collecting data from user
			Scanner s = new Scanner(System.in);
			String ans = "";
			do {
				System.out.println("Enter product name");
				String name = s.nextLine();
				System.out.println("Enter price of the product");
				double price = Double.parseDouble(s.nextLine());
				System.out.println("Enter quantity of the product");
				int quantity = Integer.parseInt(s.nextLine());
				
				String sql = "insert into tbl_product (name, price, quantity) values ('" + name + "'," + price + "," + quantity + ")";
				//System.out.println(sql);
				stmt.executeUpdate(sql);
				System.out.println("record inserted..");
				System.out.println("Do you wish to continue (y/n)");
				ans = s.nextLine();
			}
			while(ans.equals("y"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}		
	}
}
