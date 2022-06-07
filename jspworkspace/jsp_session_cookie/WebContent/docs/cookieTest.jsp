<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String co = request.getParameter("co");
	if(co != null){
		Cookie cookie = new Cookie(co, co);
		cookie.setMaxAge(60);
		response.addCookie(cookie);
	}
	
	Cookie[] cookies = request.getCookies();

	
	if(cookies != null){
		for(int i=0;i<cookies.length;i++){
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}	
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie Test</title>
</head>
<body>
	<form>
		<input type="text" name="co">
		<input type="submit" value="전송">
	</form>
</body>
</html>