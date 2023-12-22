<%@page import="com.cdac.jdbc.Product"%>
<%@page import="java.util.List"%>
<html>
<head>
<link rel="stylesheet" href="pagination.css">
</head>
<body>
<%
	List<Product> list = (List<Product>) session.getAttribute("listOfProducts");
	for(Product product : list) {
%>
			<div class="card">
				<div class="container">
    				<h4><b><%= product.getName() %></b></h4>
    				<p><%= product.getPrice() %></p>
    				<p><%= product.getQuantity() %></p>
  				</div>
			</div>
<%
		}
	%>
	<div class="card links">
		<a href="pagination.cdac?move=prev">Previous</a> |
		<a href="pagination.cdac?move=next">Next</a>	
	</div>
</body>
</html>