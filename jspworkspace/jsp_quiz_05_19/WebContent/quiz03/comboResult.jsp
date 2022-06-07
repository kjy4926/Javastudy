<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String engine = request.getParameter("engine");
		if(engine.equals("google")){
			response.sendRedirect("http://www.google.com");
		}
		else if(engine.equals("naver")){
			response.sendRedirect("http://www.naver.com");
		}
		else if(engine.equals("daum")){
			response.sendRedirect("http://www.daum.net");
		}
	%> %>
</body>
</html>