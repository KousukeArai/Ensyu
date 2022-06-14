<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
String errMsg = (String) session.getAttribute("errMsg");
String back = (String) session.getAttribute("back");
String path = (String) session.getAttribute("path");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>WEBアンケートサイト</title>
	</head>
	<body>
		<h1>WEBアンケートサイト</h1>
			<%= errMsg %><br>
		<form action= <%= path %> method="get">
			<input type="submit" value=<%= back %>>
		</form>
		
		
	</body>
</html>