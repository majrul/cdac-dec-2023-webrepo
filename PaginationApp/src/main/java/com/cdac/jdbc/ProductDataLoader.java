package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDataLoader {

	public List<Product> loadProducts(int offset) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			String sql = "select * from tbl_product limit 5 offset ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, offset);
			ResultSet rs = stmt.executeQuery();
			
			List<Product> list = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int quantity = rs.getInt(4);
				Product p = new Product(id, name, price, quantity);
				list.add(p);
			}
			return list;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null; //instead we should throw exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
