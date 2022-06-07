<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>설문조사 홈</title>
	<style>
		h1{text-align: center;}
		.menu{
			margin: auto;
			left:0; top:0; left:0; right:0;
		}
		a{text-decoration: none;}
	</style>
</head>
<body>
	<section>
		<h1>설문조사 홈페이지</h1>
		<table class="menu">
			<tr><th>기능 선택</th></tr>
			<tr><td><a href="survey.jsp">1. 설문조사 참여하기</a></td></tr>
			<tr><td><a href="surveyResultMenu.jsp">2. 설문조사 결과보기</a></td></tr>
			<tr><td><a href="gameAdd.jsp">3. 게임 추가하기</a></td></tr>
			<tr><td><a href="gameDelete.jsp">4. 게임 삭제하기</a></td></tr>
			<tr><td><a href="genreResult.jsp">5. 특정장르 결과보기</a></td></tr>
		</table>
	</section>
</body>
</html>