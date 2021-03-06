<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="${pageContext.request.contextPath}/docs/css/bootstrap.min.css" rel="stylesheet">
	<style>
		.loginform{
			width: 40%;
			margin: auto;
		}
		.submit-reset{
			float: right;
		}
	</style>
</head>
<body>
	<c:import url="nav.jsp"></c:import>
	<section class="loginform">
		<form method="post" name="login" action="${pageContext.request.contextPath}/login">
			<div class="form-group">
			  <label class="col-form-label mt-4" for="inputID">{}</label>
			  <input type="text" width="300" class="form-control" placeholder="ID" id="id" name="id" required>
			</div>
			<div class="form-group">
		      <label for="InputPassword" class="form-label mt-4">Password</label>
		      <input type="password" class="form-control" id="inputPwd" name="pwd" placeholder="Password" required>
		    </div><br>
		    <fieldset class="submit-reset">
			    <button type="submit" class="btn btn-primary">Submit</button>
		    </fieldset>
		</form>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>