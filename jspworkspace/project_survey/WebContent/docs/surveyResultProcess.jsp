<%@page import="java.util.ArrayList"%>
<%@page import="project01_survey.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="sdao" class="project01_survey.SurveyDAO"></jsp:useBean>
<% ArrayList<SurveyVO> list = null; 
	String order = request.getParameter("order");
	if(order.equals("1")) list=sdao.selectAll();
	else if(order.equals("2")) list=sdao.selectAllOrdered(false);
	else if(order.equals("3")) list=sdao.selectAllOrdered(true);
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey Result Process</title>
</head>
<body>
	<%RequestDispatcher dis = request.getRequestDispatcher("surveyResultMenu.jsp");
		dis.forward(request, response);
	%>
</body>
</html>