<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project01_survey.*" %>
<jsp:useBean id="sdao" class="project01_survey.SurveyDAO"></jsp:useBean>
<% String game = request.getParameter("game");
	sdao.updateCount(game);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey Process</title>
</head>
<body>
	<script>location.href="survey.jsp"</script>
</body>
</html>