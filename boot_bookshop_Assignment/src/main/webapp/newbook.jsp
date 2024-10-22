<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW BOOK</title>
</head>
<body>
<h1> Add new book</h1>
<form action="newbook" method="post">
 <label for="id">ID:</label><br>
 <input type="text" name="id" ><br><br>
 
 <label for="name">NAME:</label><br>
 <input type="text" name="name" ><br><br>
 
 <label for="author">AUTHOR:</label><br>
 <input type="text" name="author" ><br><br>
 
 <label for="subject">SUBJECT:</label><br>
 <input type="text" name="subject" ><br><br>
 
 <label for="price">PRICE:</label><br>
 <input type="text" name="price" ><br><br>
 
 <input type="submit" value="ADD BOOK">
</form>
  <a href="booklist">BACK TO ADD BOOK </a>
</body>
</html>