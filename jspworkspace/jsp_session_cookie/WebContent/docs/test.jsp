<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String data = request.getParameter("data");
	session.setAttribute("data", data);
	session.setMaxInactiveInterval(60);
	System.out.println(session.getMaxInactiveInterval());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	현재세션:<%=session.getId() %><br>
	data value:<%=session.getAttribute("data") %>
</body>
</html>