<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
</head>
<body>
<h1>Hello world!</h1>
<h2>${pageContext.request.contextPath}</h2>
<P>  The time on the server is ${serverTime}. </P>
<h1>하이</h1>
</body>
</html>
