<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project01_survey.*" %>
<jsp:useBean id="gao" class="project01_survey.GameDAO"></jsp:useBean>
<%
	ArrayList<GameVO> glist = gao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 삭제</title>
</head>
<body>
	<section>
		<h3>게임 삭제</h3>
		<form method="get" name="gameDelForm" action="gameDeleteProcess.jsp">
			게임 목록
			<select name="name">
				<%
					for(GameVO gvo : glist){%>
						<option><%=gvo.getName() %></option>
					<%}
				%>
			</select>
			<input type="submit" value="삭제">
		</form>
		<a href="index.jsp">홈으로 돌아가기</a>
	</section>
</body>
</html>