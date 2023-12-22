<%@page import="com.cdac.jdbc.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CalculateScoreServlet">
<%
	Question q = (Question) session.getAttribute("currentQ");
%>

Q. <%= q.getQuestion() %> <br /><br />
<input type="radio" name="op" value="1" /><%= q.getOption1() %> <br />
<input type="radio" name="op" value="2" /><%= q.getOption2() %> <br />
<input type="radio" name="op" value="3" /><%= q.getOption3() %> <br />
<input type="radio" name="op" value="4" /><%= q.getOption4() %> <br /><br />
<button type="submit">Next Question</button>
</form>
<!-- <a href="QuestionLoaderServlet2">Next Question</a>-->
</body>
</html>