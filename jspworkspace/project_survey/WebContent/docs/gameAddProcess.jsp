<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project01_survey.*" %>
<jsp:useBean id="gdao" class="project01_survey.GameDAO"></jsp:useBean>
<jsp:useBean id="gvo" class="project01_survey.GameVO"></jsp:useBean>
<jsp:useBean id="sdao" class="project01_survey.SurveyDAO"></jsp:useBean>
<jsp:useBean id="svo" class="project01_survey.SurveyVO"></jsp:useBean>
<jsp:setProperty name="gvo" property="*"/>
<jsp:setProperty name="svo" property="name"/>

<%
	boolean success = gdao.insert(gvo);
	if(success){
		success = sdao.insert(svo);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Add Process</title>
</head>
<body>
	<%
		if(success){
			out.println("게임 추가가 완료되었습니다.");
			%>
			<br><a href="index.jsp">홈으로 돌아가기</a>
		<%}else{%>
			<script>
				alert("오류가 발생하였습니다.")
				location.href="index.jsp"
			</script>
		<% }%>
</body>
</html>