<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style.css">
		<title>WEBアンケートサイト</title>
	</head>
	<body>
		<h1>WEBアンケートサイト</h1>
		Q<c:out value="${cnt + 1}" />.<c:out value="${qList.get(cnt) }" />
		<form action="/Ensyu/AnswerServlet" method="post">
		<input type="text" name="ans">
		<button type="submit">送信</button>
		</form>
	</body>
</html>