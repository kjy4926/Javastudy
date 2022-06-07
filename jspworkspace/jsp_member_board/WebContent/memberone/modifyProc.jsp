<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="memberone.*" %>
<% MemberDAO dao = MemberDAO.getInstance(); %>
<jsp:useBean id="dto" class="memberone.MemberDTO"></jsp:useBean>
<jsp:setProperty name="dto" property="*"></jsp:setProperty>
<%
	String loginID = (String)session.getAttribute("loginID");
	dto.setId(loginID);
	dao.memberUpdate(dto);
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Refresh" content="3;url=main.jsp" charset="UTF-8">
	<title>Update Process</title>
	<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<article>
		<font size="3" face="바탕체">
			<b>회원 정보가 수정되었습니다.</b><br><br>
			3초 후 로그인 페이지로 이동합니다.
		</font>
	</article>
</body>
</html>