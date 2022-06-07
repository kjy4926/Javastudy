<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%--SimpleData msg = new SimpleData(); --%>
<jsp:useBean id="msg" class="javabeans.SimpleData"/>
<%--msg.setMessage(?); --%>
<jsp:setProperty name="msg" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>간단한 빈즈 프로그램 결과</h1>
	<hr color="red"><br>
	메세지 : <jsp:getProperty property="message" name="msg"/>
	테스트 : <jsp:getProperty property="test" name="msg"/>
</body>
</html>