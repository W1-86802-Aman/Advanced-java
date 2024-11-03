<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Found Tweets</title>
</head>
<body>
    <h1>Found Tweets</h1>
    <ul>
        <c:forEach var="tweet" items="${tweets}">
            <li>
                <strong>User:</strong> ${tweet.user.firstname} ${tweet.user.lastname}<br>
                <strong>Text:</strong> ${tweet.text}<br>
                <strong>Hashtag:</strong> ${tweet.hashtag}<br>
                <strong>Date:</strong> ${tweet.tweet_datetime}<br>
            </li>
        </c:forEach>
    </ul>
    <br>
    <form method="get" action="newtweet">
        <input type="submit" value="Add New Tweet">
    </form>
    <br>
    <a href="tweets.jsp">Back to Tweets</a><br>
    <a href="logout.jsp">Logout</a>
</body>
</html>
