<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>find tweet by hashtag</title>
</head>
<body>
  <h1> all tweets by hashtag</h1>
  <form method="post" action="foundtweet">
     <label for="hashtag">hastag:</label>
     <input type="text" name="hashtag" placeholder="enter hashtag"/><br>
    <input type="submit" value="find tweet">
  </form>
</body>
</html>