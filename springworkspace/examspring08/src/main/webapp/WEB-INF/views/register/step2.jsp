<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
<h2><spring:message code="member.info"/></h2>
<form:form action="step3" modelAttribute="formData">
	<spring:message code="email"/>:
	<form:input path="email"/>
	<form:errors path="email"/><br>
	
	<spring:message code="name"/>:
	<form:input path="name"/>
	<form:errors path="name"/><br>
	
	<spring:message code="password"/>:
	<form:password path="password"/>
	<form:errors path="password"/><br>
	
	<spring:message code="password.confirm"/>:
	<form:password path="confirmPassword"/>
	<form:errors path="confirmPassword"/><br>
	
	<input type="submit" value="<spring:message code="register.btn"/>">
</form:form>
<hr>
<form action="step3" method="post">
이메일:<input type="email" name="email" value="${formData.email}" required><br>
이름:<input type="text" name="name" value="${formData.name}"><br>
비밀번호:<input type="password" name="password"><br>
비밀번호 확인:<input type="password" name="confirmPassword"><br>
<input type="submit" value="가입완료">

</form>
</body>
</html>