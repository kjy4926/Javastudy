<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>도서 등록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value='resources/css/bootstrap.min.css' />">
	<style>
		#image{width: 180px; height: 250px; visibility: hidden;}
		.book-regist{
			width: 800px;
			margin: auto;
		}
		.title{width: 150px; vertical-align: middle;}
		.star{color: red;}
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
		      	<span class="star">*</span> 표시는 필수입니다.
		      </th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row" rowspan="6"><div id="image-div">Image<Img src="" alt="book-image" id="image"></div></th>
		      <th class="title"><span class="star">*</span> BOOK ISBN</th>
		      <td><input class="form-control form-control-sm" type="number" placeholder="ISBN" id="isbn" name="isbn" required></td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 도서명</th>
		    	<td><input class="form-control form-control-sm" type="text" placeholder="TITLE" id="booktitle" name="title" required></td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 저자</th>
		    	<td><input class="form-control form-control-sm" type="text" placeholder="AUTHOR" id="author" name="author" required></td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 출판사</th>
		    	<td><input class="form-control form-control-sm" type="text" placeholder="PUBLISHER" id="publisher" name="publisher" required></td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 도서 가격</th>
		    	<td><input class="form-control form-control-sm" type="number" placeholder="PRICE" id="price" name="price" required></td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 이미지</th>
		    	<td><input class="form-control form-control-sm" type="file" id="bookimage" name="img" 
		    			onchange="setImage(this)" required></td>
		    </tr>
		    <tr>
		    	<th class="title"><span class="star">*</span> 책소개</th>
		    	<td colspan="2"><textarea class="form-control" id="description" name="content" rows="10"></textarea></td>
		    </tr>
		  </tbody>
		</table>
		<section class="button-area">
		  	<button type="submit" class="btn btn-outline-secondary" >도서 등록</button>
		  	<button type="button" class="btn btn-outline-secondary" onclick="location.href='${pageContext.request.contextPath}/'">등록 취소</button>
	  	</section>
	  </fieldset>
	</form>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
