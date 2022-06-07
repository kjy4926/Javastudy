<%@page import="java.util.ArrayList"%>
<%@page import="project01_survey.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="sdao" class="project01_survey.SurveyDAO"></jsp:useBean>
<%-- warning 제거를 위해 type check 하는 방식으로 작성 --%>
<% ArrayList<SurveyVO> list = new ArrayList<>();
	Object req = request.getAttribute("list");
	if(req instanceof ArrayList<?>){
		for(Object o : (ArrayList<?>)req){
			if(o instanceof SurveyVO){
				list.add((SurveyVO)o);
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey Result Menu</title>
</head>
<body>
	<h3>정렬 옵션 선택</h3>
	<table>
		<tr><td><a href="surveyResultProcess.jsp?order=1">1. 기본 결과보기</a></td></tr>
		<tr><td><a href="surveyResultProcess.jsp?order=2">2. 오름차순 결과보기</a></td></tr>
		<tr><td><a href="surveyResultProcess.jsp?order=3">3. 내림차순 결과보기</a></td></tr>
		<tr><td><a href="index.jsp">4. 홈으로 돌아가기</a></td></tr>
	</table>
	<%
		if(list != null){%>
			<ol><%
			for(int i=0;i<list.size();i++){%>
				<li><%=list.get(i).getName() %> => <%=list.get(i).getCount() %>표</li>
			<%}%>
			</ol>
			<%
		}%>
</body>
</html>