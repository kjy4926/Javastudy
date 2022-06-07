<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "page man");
	request.setAttribute("name", "request man");
	session.setAttribute("name", "session man");
	application.setAttribute("name", "application man");
	
	System.out.println("ex10_1jsp");
	System.out.println("page attribute" + pageContext.getAttribute("name"));
	System.out.println("request attribute" + request.getAttribute("name"));
	System.out.println("session attribute" + session.getAttribute("name"));
	System.out.println("application attribute" + application.getAttribute("name"));
	request.getRequestDispatcher("ex10_2.jsp").forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>