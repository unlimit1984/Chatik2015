<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chatik</title>
</head>
<body>
	<h1>Добро пожаловать в Чатик (Chatik)</h1>
	
	<div id="chatbox">
	
	<div>
	
	<br>

	<form action="ChatServlet" method="GET">
		Text: <input type="text" name="message">
		<input  type="hidden" name="command" value="add">
		<input type="submit" value="Отправить" />
	</form>
	
</body>
</html>