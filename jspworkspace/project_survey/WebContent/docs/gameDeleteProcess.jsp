<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project01_survey.*" %>
<jsp:useBean id="gao" class="project01_survey.GameDAO"></jsp:useBean>
<%
	String game = request.getParameter("name");
	int del = gao.delete(game);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(del > 0){
			out.println("게임 삭제가 완료되었습니다.");
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