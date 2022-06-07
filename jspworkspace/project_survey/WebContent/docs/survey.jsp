<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project01_survey.*" %>
<jsp:useBean id="sdao" class="project01_survey.SurveyDAO"></jsp:useBean>
<%
	ArrayList<SurveyVO> list = sdao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Survey</title>
</head>
<body>
	<h3>현재 투표 현황</h3>
	<section>
	<%
	if(!list.isEmpty()){%>
		<ol><%
		for(int i=0;i<list.size();i++){%>
			<li><%=list.get(i).getName() %> => <%=list.get(i).getCount() %>표</li>
			<%}%>
		</ol>
			<%
		}%>
	<% %>
	<%
	if(!list.isEmpty()){%>
		<form method="get" action="surveyProcess.jsp">
			<select name="game"><%
			for(int i=0;i<list.size();i++){%>
				<option><%=list.get(i).getName()%></option>
				<%}%>
			</select>
				<%
			}%>
			<input type="submit" value="결정">
		</form><br>
	<% 
	if(list.isEmpty()){out.println("입력된 데이터가 없습니다.");}
	%>
	<a href="index.jsp">홈으로 돌아가기</a>
	</section>
</body>
</html>