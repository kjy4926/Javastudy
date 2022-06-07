<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게임 추가</title>
	<script src="check.js"></script>
</head>
<body>
	<section>
		<form method="get" action="gameAddProcess.jsp" name="gameAddForm">
			<table class="input">
				<tr><th colspan="2">게임 정보 입력</th></tr>
				<tr>
					<td>게임 이름</td>
					<td><input name="name" type="text"></td>
				</tr>
				<tr>
					<td>게임 장르</td>
					<td><input name="type" type="text"></td>
				</tr>
			</table>
			<input type="button" value="추가" onclick="gameAddCheck()">
			<input type="reset" value="취소">
			<br><a href="index.jsp">홈으로 돌아가기</a>
		</form>
	</section>
</body>
</html>