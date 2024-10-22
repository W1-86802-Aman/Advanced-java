<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
   <h2> REGISTRATION</h2>
   
   <sf:form modelAttribute="cust" action="register">
    <label for="name"> Full Name:</label><br>
    <sf:input path="name" placeholder="enter your name"/> <br><br>
    
     <label for="email">Email:</label><br>
        <sf:input path="email" placeholder="Enter your email"/><br><br>

        <label for="password">Password:</label><br>
        <sf:password path="password" placeholder="Create a password"/><br><br>

        <label for="mobile">Mobile Number:</label><br>
        <sf:input path="mobile" placeholder="Enter your mobile number"/><br><br>

        <label for="address">Address:</label><br>
        <sf:textarea path="address" placeholder="Enter your address" rows="4" cols="50"/><br><br>

        <label for="birthdate">Date of Birth:</label><br>
        <sf:input type="date" path="birth"/><br><br>

        <input type="submit" value="Register">
   </sf:form>
   <p>${message}</p>
    <p>Already have an account? <a href="index">Login here</a></p>
</body>
</html>