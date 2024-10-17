<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Books List Page</title>
</head>
<body>
<jsp:useBean id="blb" class="com.sunbeam.beans.BookListBean"></jsp:useBean>
<jsp:setProperty property="*" name="blb"/>
${blb.fetchBooks()}
	<hr>
	<h3 align="center">ADMIN PANEL</h3>
	<hr>
	<div align="center">
		<fieldset>
			<table border='1' cellpadding='10'>
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>AUTHOR</th>
						<th>SUBJECT</th>
						<th>PRICE</th>
						<th>EDIT</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<c:forEach var="bk" items="${blb.books}">
					<tr>
						<td>${bk.id}</td>
						<td>${bk.name}</td>
						<td>${bk.author}</td>
						<td>${bk.subject}</td>
						<td>${bk.price}</td>
						<td align='center'><a href='editbook?bookId=${bk.id}'><img
								src='edit.png' alt='Edit' width='26' height='26' /></a></td>
						<td align='center'><a href='delbook?bookId=${bk.id}'><img
								src='delete.png' alt='Delete' width='28' height='28' /></a></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</div>
	<br>

	<table align='center' cellpadding='10'>
		<tr>
			<td>
				<p>
					<a href='/ServletProject/pages/Logout.html'>
						<button>Sign Out</button>
					</a>
				</p>
			</td>
			<td>
				<p>
					<a href='/ServletProject/pages/AddBook.html'>
						<button>Add Book</button>
					</a>
				</p>
			</td>
		</tr>
	</table>
</body>
</html>