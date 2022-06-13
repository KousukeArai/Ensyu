<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
List<String> qList = (List<String>) session.getAttribute("qList");
Integer cnt = (Integer) session.getAttribute("cnt");
String question= qList.get(cnt);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>WEBアンケートサイト</title>
	</head>
	<body>
		<h1>WEBアンケートサイト</h1>
		Q<%= cnt + 1 %>. <%= question %><br>
		<form action="/Ensyu/AnswerServlet" method="post">
		<input type="text" name="ans"><br>
		<input type="submit" value="送信">
		</form>
	</body>
</html>