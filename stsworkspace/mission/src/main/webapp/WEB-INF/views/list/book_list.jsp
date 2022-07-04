<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<html>
<head>
	<title>도서 목록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<style>
		.center{text-align: center;}
		img{width: 80px; height: 120px;}
		tr{vertical-align: middle;}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<c:import url="/nav2"></c:import>
	
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th scope="col" class="center">등록 번호</th>
	      <th scope="col">도서 표지</th>
	      <th scope="col">ISBN</th>
	      <th scope="col" style="width: 20%">도서 제목 </th>
	      <th scope="col" style="width: 20%">저자</th>
	      <th scope="col" style="width: 20%">출판사</th>
	      <th scope="col">가격</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="book" items="${booklist}" varStatus="vs">
		    <tr onclick="location.href='${pageContext.request.contextPath}/read/${book.id}'">
		      <th scope="row" class="center">${book.id}</th>
		      <td><img src="${pageContext.request.contextPath}/resources/img/${book.img}"></td>
		      <td>${book.isbn}</td>
		      <td>${book.title}</td>
		      <td>${book.author}</td>
		      <td>${book.publisher}</td>
		      <td><fmt:formatNumber value="${book.price}" pattern="#,###"/></td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<!-- Paging -->
	<div style="width: 200px; height: 100px; margin: auto;">
		<c:choose>
			<c:when test="${maxP <= 5}">
			  <ul class="pagination">
			  	<li class="page-item">
			      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP}">&laquo;</a>
			    </li>
			  	<c:forEach var="i" begin="1" end="${maxP}" varStatus="vs">
				  	<li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP-vs.index}">${maxP-vs.index}</a>
				    </li>
			  	</c:forEach>
			    <li class="page-item">
			      <a class="page-link" href="${pageContext.request.contextPath}/list">&raquo;</a>
			    </li>
			  </ul>
			</c:when>
			<c:when test="${p<=3}">
				<ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP}">&laquo;</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/5">5</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/4">4</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/3">3</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/2">2</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/1">1</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list">&raquo;</a>
				    </li>
				</ul>
			</c:when>
			<c:when test="${maxP-p <= 2}">
				<ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP}">&laquo;</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP}">${maxP}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP-1}">${maxP-1}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP-2}">${maxP-2}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP-3}">${maxP-3}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP-4}">${maxP-4}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list">&raquo;</a>
				    </li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${maxP}">&laquo;</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${p+2}">${p+2}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${p+1}">${p+1}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${p}">${p}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${p-1}">${p-1}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list/${p-2}">${p-2}</a>
				    </li>
				    <li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/list">&raquo;</a>
				    </li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function getSearch(){
		    var urlParams = new URL(location.href).searchParams
		    var search = urlParams.get('search')
		    console.log(search)
		    return search
		}
		$('a').bind('click', function(){ 
			//현재 이벤트가 적용된 index와 html 그 자체를 인자값으로 넣을 수 있음.
			var search = getSearch()
			if(search != null){
				this.setAttribute('href', this.getAttribute('href')+'?search='+search)
			}
		});
	</script>
</body>
</html>
