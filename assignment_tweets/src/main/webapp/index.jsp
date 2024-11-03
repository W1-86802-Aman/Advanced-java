<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
  <h1>Login Here</h1>
  <form method="post" action="login">
   <label for="email">email:</label>
   <input type="text" name="email" placeholder="enter email"/><br><br>
   
   <label for="password">password</label>
   <input type="text" name="password" placeholder="enter password">
   <br><br>
   
   <input type="submit" value="login"/>
  </form>
</body>
</html>