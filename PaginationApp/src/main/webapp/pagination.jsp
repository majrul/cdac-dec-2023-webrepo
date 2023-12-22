<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<link rel="stylesheet" href="pagination.css">
</head>
<body>
<%

	int offset = 0;

	Connection conn = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
		String sql = "select * from tbl_product limit 5 offset ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, offset);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			int quantity = rs.getInt(4);
%>
			<div class="card">
				<div class="container">
    				<h4><b><%= name %></b></h4>
    				<p><%= price %></p>
    				<p><%= quantity %></p>
  				</div>
			</div>
<%
		}
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	finally {
		try { conn.close(); } catch(Exception e) { }
	}
%>
	<div class="card links">
		<a href="#">Previous</a> |
		<a href="#">Next</a>	
	</div>
</body>
</html>