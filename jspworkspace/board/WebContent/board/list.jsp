<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.BoardDAO" %>
<%@ page import = "board.BoardDTO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%!
    //수정<1>
	int pageSize = 10;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%
    //수정<2>
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
	 pageNum = "1";
	}
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage - 1) * pageSize + 1;
	int endRow = currentPage * pageSize;
    int count = 0;
    int number = 0;
    List<BoardDTO> articleList = null;
    BoardDAO dbPro = BoardDAO.getInstance();
    count = dbPro.getArticleCount(); //전체 글 수
    if(count > 0){
        articleList = dbPro.getArticles(startRow, endRow); //수정<3>
    }
    number = count - (currentPage-1) * pageSize; //수정<4>
%>
<!doctype html>
<html>
<head>
<title>게시판</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/liststyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<section>
		<article>
			<b>글목록(전체 글:<%= count %>)</b>
			<table class="listwritebutton">
			    <tr>
			    <td><a href="writeForm.jsp">글쓰기</a></td>
			    <tr>
			</table>
		<%
		    if(count == 0){
		%>
			<table class="listtable">
			<tr>
			    <td>게시판에 저장된 글이 없습니다.</td>
			</table>
			<% } else { %>
			<table  class="listtable">
			    <tr>
			        <th id="num">번 호</th>
			        <th id="title">제 목</th>
			        <th id="writer">작성자</th>
			        <th id="date">작성일</th>
			        <th id="counter">조 회</th>
			        <th id="ip">IP</th>
			    </tr>
			<%
			    for(int i = 0; i < articleList.size(); i++){
			        BoardDTO article = (BoardDTO)articleList.get(i);
			%>
			    <tr>
			        <td> <%= number-- %></td>
			        <td class="titletd">
			        <!-- 수정<5> -->
			        <%
					 int wid = 0;
					 if(article.getDepth() > 0){
					  wid = 5 * (article.getDepth());
					 %>
					  <img src="images/level.gif" width="<%=wid%>">
					  <img src="images/re.gif">
					 <% } else {%>
					  <img src="images/level.gif" width="<%=wid%>">
					 <% } %>
			        <a href="content.jsp?num=<%= article.getNum() %>&pageNum=<%=currentPage%>"><!-- 수정<6> -->
			            <%= article.getSubject() %></a>
			            <% if(article.getReadcount() >= 20){ %>
			            <img src="images/hot.gif"><% } %></td>
			        <td>
			            <a href="mailto:<%= article.getEmail() %>">
			            <%= article.getWriter() %></a></td>
			        <td>
			            <%= sdf.format(article.getRegdate()) %></td>
			        <td><%= article.getReadcount() %></td>
			        <td><%= article.getIp() %></td>
			    </tr>
			        <% } %>
			</table>
		</article>
		<% } %>
		<%
		 if(count > 0){
		  int pageBlock = 5;
		  int imsi = count % pageSize == 0 ? 0 : 1;
		  int pageCount = count / pageSize + imsi;
		  int startPage = (int)((currentPage-1) / pageBlock) * pageBlock + 1;
		  int endPage = startPage + pageBlock - 1;
		  if( endPage > pageCount) endPage = pageCount;
		  if(startPage > pageBlock) { %>
		   <a href="list.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a>
		<% 
		  }
		  for(int i = startPage; i <= endPage; i++){ %>
		   <a href="list.jsp?pageNum=<%=i%>">[<%=i%>]</a>
		<% 
		  }
		  if(endPage < pageCount) { %>
		   <a href="list.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a>
		<%
		  }
		 }
		%>
	</section>
</body>
</html>
