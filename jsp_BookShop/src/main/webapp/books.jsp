<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Books</h1>
<jsp:useBean id="bb" class="com.sunbeam.beans.BooksBean"/>
<jsp:setProperty name="bb" property="*"/>
${bb.fetchBooks()}
<form method="post" action="addcart.jsp">
<c:forEach var="b" items="${bb.books }">
  <input type="checkbox" name="book" value="${b.id }"/> ${b.name }-${b.author}<br>
</c:forEach>
<input type="submit" value="ADD CART"/>
</form>
</body>
</html>