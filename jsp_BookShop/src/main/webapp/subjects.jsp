<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>
    hello..,${lb.cust.name}
	<h2>Subjects</h2>
	<jsp:useBean id="sb" class="com.sunbeam.beans.SubjectsBean"/>
	${sb.fetchSubjects()}
	<form method="post" action="books.jsp">
		<c:forEach var="sub" items="${sb.subjects}">
				
			<input type="radio" name="subject" value="${sub}"/> ${sub} <br/>
		</c:forEach>
		<input type="submit" value="Show Books"/>
		<p>
		<a href="showcart.jsp">Show Cart</a>
		</p>
	</form>
</body>
</html>