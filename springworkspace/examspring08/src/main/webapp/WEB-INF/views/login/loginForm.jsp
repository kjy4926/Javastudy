<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<form:form modelAttribute="loginCommand">
		<spring:message code="email"/>
		<form:input path="email"/>
		<form:errors path="email"/><br>
		
		<spring:message code="password"/>
		<form:input path="password"/>
		<form:errors path="password"/><br>
		<form:errors/><br> <!-- 글로벌 에러코드 출력 -->
		
		<spring:message code="rememberEmail"/>
		<form:checkbox path="rememberEmail"/><br>
		<input type="submit" value="<spring:message code="login.btn"/>">
	</form:form>
</body>
</html>