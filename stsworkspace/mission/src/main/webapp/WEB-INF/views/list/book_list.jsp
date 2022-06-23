<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<html>
<head>
	<title>도서 목록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value='resources/css/bootstrap.min.css' />">
	<style>
		.center{text-align: center;}
		img{width: 120px; height: 200px;}
		tr{vertical-align: middle;}
	</style>
</head>
<body>
	<c:import url="/nav2"></c:import>
	
	<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col" class="center">등록 번호</th>
      <th scope="col">도서 표지</th>
      <th scope="col">ISBN</th>
      <th scope="col">도서 제목 </th>
      <th scope="col">저자</th>
      <th scope="col">출판사</th>
      <th scope="col">가격</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="book" items="${booklist}" varStatus="vs">
	    <tr>
	      <th scope="row" class="center">${book.id}</th>
	      <td><img src="<c:url value='/resources/img/${book.img}' />"></td>
	      <td>${book.isbn}</td>
	      <td>${book.title}</td>
	      <td>${book.author}</td>
	      <td>${book.publisher}</td>
	      <td><fmt:formatNumber value="${book.price}" pattern="#,###"/></td>
	    </tr>
    </c:forEach>
  </tbody>
</table>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
