<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	입력하신 정보는 아래와 같습니다.<br><br>
	학력 : <%=request.getParameter("edu") %><br><br>
	국가 : <%=request.getParameter("nation") %><br><br>
	관심 분야 : <%
		String[] values = request.getParameterValues("interest");
		if(values != null){
			for(String s : values){
				out.print(s + " ");
			}
		}
	%>
	
</body>
</html>