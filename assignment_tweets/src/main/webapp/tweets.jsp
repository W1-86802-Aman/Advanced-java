<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All tweets</title>
</head>
<body>
  <h1>all tweets</h1>
  <c:forEach var="t" items="${ tweets}">
    <input type="radio" name="tweet" value="${t }"/>${t.text}---${t.hashtag }---${t.tweet_datetime }<br>
  </c:forEach>
  <a href="newtweet">New Tweets</a><br>
  <a href="findhashtag_tweet">Find Tweet By hashtags</a><br>
  <a href="logout">logout</a>
</body>
</html>