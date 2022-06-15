<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style.css">
		<title>WEBアンケートサイト</title>
	</head>
	<body>
	    <div class="wrap">
  			<header class="header">
				<h1 class="logo">WEBアンケートサイト TOPページ</h1>
			</header>
	  		<main class="main">
		    	<form action="/Ensyu/TopServlet" method="post">
		    		<div class="iptext">
		    			<label class="ef" for="name">名前</label><br>
		    			<input type="text" name="name" placeholder="名前">
		    		</div>
		    		<div class="iptext">
		    			<label class="ef" for="pref">都道府県</label><br>
		    			<input type="text" name="pref" placeholder="都道府県">
		    		</div>
		    		<div class="iptext">
		    			<label class="ef" for="city">市区町村</label><br>
		    			<input type="text" name="city" placeholder="市区町村">
		    		</div><br>
		    		<button type="submit" class="button">アンケートの回答に進む</button>
		    	</form>
		</main>
		</div>
	</body>
</html>