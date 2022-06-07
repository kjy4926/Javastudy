<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/mul">
		<input type="text" name="n1">*<input type="text" name="n2">
		<input type="submit" value="곱하기"> 
	</form>
</body>
</html>