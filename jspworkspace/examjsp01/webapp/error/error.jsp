<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error!!</title>
</head>
<body>
	에러 발생.<br><br>
	에러타입 : <%=exception.getClass().getName() %><br><br>
	에러 메세지 : <%=exception.getMessage() %>
</body>
</html>