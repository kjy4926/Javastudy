<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>navigation</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="${pageContext.request.contextPath}/index">JYWeb</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="true" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	
	    <div class="navbar-collapse collapse show" id="navbarColor01" style="">
	      <ul class="navbar-nav me-auto">
	        <li class="nav-item">
	          <a class="nav-link active" href="${pageContext.request.contextPath}/index">Home
	            <span class="visually-hidden">(current)</span>
	          </a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Board</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Download</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Member Info</a>
	          <c:choose>
	          	<c:when test="${empty sessionScope.loginID}">
		          	<div class="dropdown-menu">
			            <a class="dropdown-item" href="${pageContext.request.contextPath}/loginform">Login</a>
			            <div class="dropdown-divider"></div>
			            <a class="dropdown-item" href="${pageContext.request.contextPath}/signupform">Sign up</a>
		          	</div>
	          	</c:when>
	          	<c:otherwise>
	          		<div class="dropdown-menu">
			            <a class="dropdown-item" href="#">ID</a>
			            <div class="dropdown-divider"></div>
			            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
		          	</div>
	          	</c:otherwise>
	          </c:choose>
	        </li>
	      </ul>
	      <form class="d-flex">
	        <input class="form-control me-sm-2" type="text" placeholder="Search">
	        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>
</body>
</html>