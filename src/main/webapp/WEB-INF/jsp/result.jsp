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
<meta charset="UTF-8">
<title>WEBアンケートサイト</title>
</head>
<body>
<h2>アンケート結果</h2>

<%for(int i = 0; i < qList.size(); i++){ %>
	<p>Q<%=i + 1 %>. <%= qList.get(i) %></p>
	<p>A. <%= ansList.get(i) %></p><br>
<%} %>
<p>ご協力ありがとうございました。</p><br>

<a href="/Ensyu/TopServlet">TOPに戻る</a>

</body>
</html>