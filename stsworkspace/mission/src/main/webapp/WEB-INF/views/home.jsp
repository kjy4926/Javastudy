<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>도서 정보</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value='resources/css/bootstrap.min.css' />">
	<style>
		.book-regist{
			width: 800px;
			margin: auto;
		}
		.title{width: 150px; vertical-align: middle;}
		.button-area{float: right;}
	</style>
	<script src="<c:url value='resources/js/bookadd.js'/>"type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<c:import url="/nav"></c:import><br>

	<form method="post" onsubmit="fileTransfer(this)" action="${pageContext.request.contextPath}/add">
	  <fieldset class="book-regist">
	    <legend>도서 정보</legend>
	    <table class="table">
		  <thead>
		    <tr>
		      <th scope="col" colspan="3" style="text-align: right">
		      	<span class="star"></span> 도서 정보
		      </th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row" rowspan="6"><div id="image-div">Image<Img src="" alt="book-image" id="image"></div></th>
		      <th class="title">BOOK ISBN</th>
		      <td></td>
		    </tr>
		    <tr>
		    	<th class="title">도서명</th>
		    	<td></td>
		    </tr>
		    <tr>
		    	<th class="title">저자</th>
		    	<td></td>
		    </tr>
		    <tr>
		    	<th class="title">출판사</th>
		    	<td></td>
		    </tr>
		    <tr>
		    	<th class="title">도서 가격</th>
		    	<td></td>
		    </tr>
		    <tr>
		    	<th class="title"></th>
		    	<td></td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 책소개</th>
		    	<td colspan="2"></td>
		    </tr>
		  </tbody>
		</table>
	  </fieldset>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
