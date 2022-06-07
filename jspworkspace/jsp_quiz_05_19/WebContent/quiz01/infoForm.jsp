<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="infoResult.jsp">
	ID : <input name="id" type="text"><br>
	Password : <input name="pwd" type="password"><br>
	자기소개<br>
	<textarea name="pr" rows="5" cols="50"></textarea><br>
	<input type="submit" value="제출">
	</form>
</body>
</html>