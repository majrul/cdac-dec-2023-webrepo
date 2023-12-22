<%@page import="com.cdac.jdbc.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.cdac.jdbc.ProductDataLoader"%>
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
<%!
	int offset = 0;
%>

<!-- TODO:
	Display the page details, for ex:
	Showing 1 - 5 of 19 Products
 -->

<%
	String move = request.getParameter("move");
	if(move != null) {
		//TODO: Add the missing boundary conditions for next and prev
		if(move.equals("next"))
			offset += 5;
		else if(move.equals("prev"))
			offset -= 5;
	}
	
	ProductDataLoader loader = new ProductDataLoader();
	List<Product> list = loader.loadProducts(offset);
	for(Product product : list) {
%>
			<div class="card">
				<div class="container">
    				<h4><b><%= product.getName() %></b></h4>
    				<%= product.getPrice() %> <br />
    				<%= product.getQuantity() %>
  				</div>
			</div>
<%
		}
	%>
	<div class="card links">
		<a href="pagination3.jsp?move=prev">Previous</a> |
		<a href="pagination3.jsp?move=next">Next</a>	
	</div>
	
	<h2>Showing <%= offset+1 %> to <%= offset+5 %></h2>
</body>
</html>