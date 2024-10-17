<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add cart</title>
</head>
<body>
<jsp:useBean id="cb" class="com.sunbeam.beans.Cartbean" scope="session"/>
<jsp:setProperty name="cb" property="bookIds" param="book"/>
${cb.addToCart()}
<jsp:forward page="subjects.jsp">
<jsp:param name="cart_count" value="${cb.booklist.size() }"/>
</jsp:forward>
</body>
</html>