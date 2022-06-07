<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	입력 정보
	ID : <%=request.getParameter("id") %><br>
	Password : <%=request.getParameter("pwd") %><br>
	자기 소개<br>
	<%=request.getParameter("pr").replace("\n", "<br>") %><br>
</body>
</html>