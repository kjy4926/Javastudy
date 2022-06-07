<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project01_survey.*" %>
<jsp:useBean id="sdao" class="project01_survey.SurveyDAO"></jsp:useBean>
<%
	String type = request.getParameter("type");
	ArrayList<SurveyVO> list = sdao.selectByTypeJoinWithGame(type);
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%RequestDispatcher dis = request.getRequestDispatcher("genreResult.jsp");
		dis.forward(request, response);
	%>
</body>
</html>