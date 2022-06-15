<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.UserModel" %>
<%
List<String> qList = (List<String>) session.getAttribute("qList");
List<String> ansList = (List<String>) session.getAttribute("ansList");
UserModel user = (UserModel) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
		<meta charset="UTF-8">
		<title>WEBアンケートサイト</title>
	</head>
	<body>
		<h1>アンケート結果</h1>
		<%for(int i = 0; i < qList.size(); i++){ %>
			<p>Q<%=i + 1 %>. <%= qList.get(i) %></p>
			<p class="textAns"><span>A. <%= ansList.get(i) %></span></p><br>
		<%} %>
		<p>ご協力ありがとうございました。</p><br>
		<a href="/Ensyu/TopServlet">TOPに戻る</a>
	</body>
</html>