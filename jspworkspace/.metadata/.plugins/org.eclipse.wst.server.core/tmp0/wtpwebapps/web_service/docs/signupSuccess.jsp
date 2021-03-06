<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign up result</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="${pageContext.request.contextPath}/docs/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		section{
			text-align: center;
			margin: 0 auto;
			max-width: 40%;
		}
	</style>
</head>
<body>
	<section>
		<c:choose>
			<c:when test="${signupsuccess}">
				<H1>Welcome JYWeb Page!</H1>
				<div class="card">
				  <div class="card-body">
				    <h4 class="card-title">Congratulation</h4>
				    <h6 class="card-subtitle mb-2 text-muted">Sign up success!</h6>
				    <p class="card-text">Congratulations on joining JYWeb. Try various functions such as bulletin boards and file uploads!</p>
				    <a href="${pageContext.request.contextPath}/index" class="card-link">Home</a>
				    <a href="${pageContext.request.contextPath}/loginform" class="card-link">Login</a>
				  </div>
				</div>
			</c:when>
			<c:otherwise>
				<H1>Sorry, an error has occurred.</H1>
				<div class="card">
				  <div class="card-body">
				    <h4 class="card-title">Error</h4>
				    <h6 class="card-subtitle mb-2 text-muted">Sign up failed!</h6>
				    <p class="card-text">An error has occurred. Please try again.</p>
				    <a href="${pageContext.request.contextPath}/index" class="card-link">Home</a>
				    <a href="${pageContext.request.contextPath}/signupform" class="card-link">Sign up</a>
				  </div>
				</div>
			</c:otherwise>
		</c:choose>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>