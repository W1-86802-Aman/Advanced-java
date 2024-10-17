<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form method="post" action="login.jsp">
    <label for="email">EMAIL:</label>
    <input type="text" name="email" placeholder="Enter your email"><br><br>
    
    <label for="password">PASSWORD:</label>
    <input type="text" name="password" placeholder="Enter your password"><br><br>
    
    <input type="submit" value="LOGIN HERE">  
    
    <p> dont't have an account ? <a href ="newuser.jsp">Sign..Up..?</a></p>
  </form>
</body>
</html>