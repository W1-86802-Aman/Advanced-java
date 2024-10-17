<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Logout thank you for using online cart</h1>
<%session.invalidate(); %>
<a href="index.jsp">Got to login page again</a>

</body>
</html>