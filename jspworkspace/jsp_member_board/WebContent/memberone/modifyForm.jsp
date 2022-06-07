<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberone.*" %>
<% MemberDAO dao = MemberDAO.getInstance(); %>
<%
	String loginID = (String)session.getAttribute("loginID");
	MemberDTO dto = dao.getMember(loginID);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modify Form</title>
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<link href="css/regFormstyle.css" rel="stylesheet" type="text/css">
	<script src="script.js"></script>
</head>
<body>
	<section>
		<form method="post" action="modifyProc.jsp" name="regForm">
			<table class="regtable">
				<tr>
					<th colspan="2">회원 수정 정보 입력</th>
				</tr>
				<tr>
					<td>아이디 </td>
					<td><%=dto.getId() %></td>
				</tr>
				<tr>
					<td>패스워드 </td>
					<td><input type="password" name="pass" value="<%=dto.getPass() %>">
				</tr>
				<tr>
					<td>패스워드 확인 </td>
					<td><input type="password" name="repass" value="<%=dto.getPass() %>">
				</tr>
				<tr>
					<td>이메일 </td>
					<td><input type="email" name="email" value="<%=dto.getEmail() %>"></td>
				</tr>
				<tr>
					<td colspan="2" class="regsubmit">
					<input type="button" value="정보 수정" onClick="updateCheck()">
					<input type="button" value="취소" onClick="javascript:window.location='main.jsp'">
				</tr>
			</table>
		</form>
	</section>
</body>
</html>