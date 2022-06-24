<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>도서 정보</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<style>
		.book-read{
			width: 800px;
			margin: auto;
		}
		.title{width: 150px; vertical-align: middle;}
		td{vertical-align: middle;}
		img{width: 180px; height: 250px;}
	</style>
</head>
<body>
	<c:import url="/nav"></c:import><br>

	<form>
	  <fieldset class="book-read">
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
		      <th scope="row" rowspan="5"><div id="image-div">Image
		      	<Img src="${pageContext.request.contextPath}/resources/img/${book.img}" alt="book-image" id="image"></div></th>
		      <th class="title">BOOK ISBN</th>
		      <td>${book.isbn}</td>
		    </tr>
		    <tr>
		    	<th class="title">도서명</th>
		    	<td>${book.title}</td>
		    </tr>
		    <tr>
		    	<th class="title">저자</th>
		    	<td>${book.author}</td>
		    </tr>
		    <tr>
		    	<th class="title">출판사</th>
		    	<td>${book.publisher}</td>
		    </tr>
		    <tr>
		    	<th class="title">도서 가격</th>
		    	<td>${book.price}</td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 책소개</th>
		    	<td colspan="2"><p>${book.content}</p></td>
		    </tr>
		  </tbody>
		</table>
	  </fieldset>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
