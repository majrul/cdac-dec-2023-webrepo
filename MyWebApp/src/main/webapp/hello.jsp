<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to JSP</h1>
<%
LocalDate date = LocalDate.now();
%>
<h2>Today's Date is <%= date %></h2>
<%
	String str = "Hello Everyone!";
%>
<h3><%= str %></h3>
<center>
<%
	for(int i=1; i<=6; i++) {
%>
		<font size="<%= i %>">Hello Everyone!</font><br />	
<%
	}
%>
TODO: Display Table of 2 (Output: 2 * 1 = 2 2 * 2 = 4 2 * 3 = 6)
</center>
</body>
</html>

<%--
 <% ... %> --> Scriptlet
 <%= ... %> --> Expression
 <%@ ... %> --> Directive
 <%! ... %> --> Declaration
--%>
