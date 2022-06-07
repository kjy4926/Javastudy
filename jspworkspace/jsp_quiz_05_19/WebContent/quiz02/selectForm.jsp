<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.title{
			font-weight: bold;
			padding: px10 5px 10px 5px;
		}
	</style>
</head>
<body>
	<form method="post" action="selectResult.jsp">
		<table>
		<tr>
			<td class="title">학력</td>
			<td>
				<select name="edu">
					<option value="고졸">고등학교 졸업</option>
					<option value="대학 재학">대학 재학</option>
					<option value="대학 졸업">대학 졸업</option>
					<option value="대학원">대학원</option>
				</select><br>
			</td>
		</tr>
		<tr>
			<td class="title">국가</td>
			<td>
				<select name="nation" size=4>
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="중국">중국</option>
					<option value="미국">미국</option>
				</select><br>
			</td>
		</tr>
		<tr>
			<td class="title">관심분야</td>
			<td>
				<select name="interest" multiple>
					<option value="FE">FE</option>
					<option value="BE">BE</option>
					<option value="Client">Client</option>
					<option value="Server">Server</option>
				</select><br>
			</td>
		</tr>
		</table>
		<input type="submit" value="제출">
	</form>
</body>
</html>