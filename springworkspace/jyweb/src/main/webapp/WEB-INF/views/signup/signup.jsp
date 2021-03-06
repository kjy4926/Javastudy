<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Sign up</title>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<style>
		.loginform{
			width: 40%;
			margin: auto;
		}
		.submit-reset{
			float: right;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/signup.js" />"></script>
</head>
<body>
	<c:import url="/nav"></c:import>
	<section class="loginform">
		<form method="post" name="signup-form" onsubmit="return signUp(this)" action="${pageContext.request.contextPath}/signup/signup.do">
			<fieldset>
				<br><legend>Sign Up</legend>
				<div class="form-group has-danger has-success">
					<label class="form-label mt-4" for="inputID">ID</label>
					<input type="text" placeholder="ID input" class="form-control" id="inputID" name="id"
					 	pattern="^[a-z][a-z0-9]{7,15}$" oninput="idValidCheck(this.form)" required>
					<div class="invalid-feedback"><span id="idResultInValid"></span></div>
					<div class="valid-feedback"><span id="idResultValid"></span></div>
					<small id="idHelp" class="form-text text-muted">ID is 8~16 character. only lowercase and number</small>
					<button type="button" class="btn btn-primary btn-sm disabled" name="idcheck"
						onclick="dupCheck(this.form)" style="float:right;" >Duplicate check</button>
					<input type="hidden" id="dupflag" name="dupck" value="0"> 
				</div>
				<div class="form-group">
			      <label for="InputPassword" class="form-label mt-4">Password</label>
			      <input type="password" class="form-control" id="inputPwd" name="pwd" placeholder="Password" 
			      		pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$$" required>
			      <small id="pwdHelp" class="form-text text-muted">Password is 8~15 character. only alphanumeric and special symbol</small><br>
			      <small id="pwdHelp2" class="form-text text-muted">At least one alphabet, number, and special symbol are required.</small>
			    </div>
			    <div class="form-group">
			      <label for="InputPasswordCheck" class="form-label mt-4">Password Check</label>
			      <input type="password" class="form-control" id="inputPwdck" name="pwdck" placeholder="Password Check" 
			      		pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$$" required>
			    </div>
			    <div class="form-group">
			      <label for="InputEmail1" class="form-label mt-4">Email address</label>
			      <input type="email" class="form-control" id="inputEmail1" name="email" 
			      		pattern="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" aria-describedby="emailHelp" placeholder="Enter email" required>
			      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			    </div><br>
		    </fieldset>
		    <fieldset class="submit-reset">
			    <button type="reset" class="btn btn-primary">Reset</button>
			    <button type="submit" class="btn btn-primary">Sign up</button>
		    </fieldset>
		</form>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>