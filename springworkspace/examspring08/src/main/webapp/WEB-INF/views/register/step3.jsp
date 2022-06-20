<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
<spring:message code="register.done" arguments="${formData.name}, 12"/>
${formData.name}회원가입을 축하합니다.<br>
<a href="<c:url value='/main'/>"><spring:message code="go.main"/></a>
</body>
</html>