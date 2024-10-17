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
     <jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"></jsp:useBean>
     <jsp:setProperty name="lb" property="*"/>
     ${lb.authenticate()}
     <c:choose>
      <c:when test="${lb.cust.password =='admin'}">
         <c:redirect url="BookList.jsp"/> 
         </c:when>
       <c:when test="${not empty lb.cust}">
       <c:redirect url="subjects.jsp"/>
       </c:when>
      
       <c:otherwise>
			Invalid email or password.
			<p>
				<a href="index.jsp">Login Again</a>
			</p>
			</c:otherwise>   
     </c:choose>
</body>
</html>