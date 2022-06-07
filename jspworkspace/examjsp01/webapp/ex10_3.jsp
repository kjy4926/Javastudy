<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ex10_3.jsp</h2>
	page attribute : <%=pageContext.getAttribute("name") %><br>
	request attribute : <%=request.getAttribute("name") %><br>
	session attribute : <%=session.getAttribute("name") %><br>
	application attribute : <%=application.getAttribute("name") %><br>
</body>
</html>