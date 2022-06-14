<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style.css">
		<title>WEBアンケートサイト</title>
<!-- 		<style type="text/css">
		h1 {
				background-color: #eeece9;
		}
		</style> -->
	</head>
	<body>
		<h1>WEBアンケートサイト TOPページ</h1>
		<form action="/Ensyu/TopServlet" method="post">
			名前：<br>
			<input type="text" name="name"><br>
			都道府県：<br>
			<input type="text" name="pref"><br>
			市区町村：<br>
			<input type="text" name="city"><br>
			<br>
			<button type="submit">アンケートの回答に進む</button>
		</form>
	</body>
</html>