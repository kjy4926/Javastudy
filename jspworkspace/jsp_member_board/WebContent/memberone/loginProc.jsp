<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberone.*" %>
<% MemberDAO dao = MemberDAO.getInstance(); %>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	int check = dao.loginCheck(id, pass);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(check == 1){
		session.setAttribute("loginID", id);
		response.sendRedirect("main.jsp");
	}
	else if(check == 0){%>
		<script>
			alert("비밀번호가 잘못되었습니다.");
			history.go(-1);
		</script>
	<% }
	else { %>
		<script>
			alert("존재하지 않는 아이디입니다.")
			history.go(-1);
		</script>
	<%}%>
</body>
</html>