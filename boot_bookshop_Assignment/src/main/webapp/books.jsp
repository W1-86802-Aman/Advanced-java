<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>books</title>
</head>
<body>
<h1> Hello,<c:out value="${username}"></c:out></h1>
  <h1>Books</h1>
  <form method="post" action="addcart">
    <c:forEach var="b" items="${bookList}">
      <input type="checkbox" name="book" value="${b.id }"/>${b.name}-${b.author}<br>
       
    </c:forEach>
    <input type="submit" value="Add Cart"/>
  </form>
</body>
</html>