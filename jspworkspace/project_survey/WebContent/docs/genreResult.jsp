<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project01_survey.*" %>
<jsp:useBean id="gdao" class="project01_survey.GameDAO"></jsp:useBean>

<% 
	ArrayList<String> genre = gdao.selectAllType();
	ArrayList<SurveyVO> list = new ArrayList<>();
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
<title>장르별 결과 보기</title>
</head>
<body>
	<h3>장르별 결과 출력</h3>
	<section>
		<form action="genreResultProcess.jsp">
			장르 선택
			<select name="type">
				<%
					for(String s : genre){%>
						<option><%=s %></option>
					<% 
					}
				%>
			</select>
			<input type="submit" value="검색">
		</form>
	</section>
	<%
		if(list != null){%>
			<ol><%
			for(int i=0;i<list.size();i++){%>
				<li><%=list.get(i).getName() %> => <%=list.get(i).getCount() %>표</li>
			<%}%>
			</ol>
			<%
		}%>
	<a href="index.jsp">홈으로 돌아가기</a>
</body>
</html>