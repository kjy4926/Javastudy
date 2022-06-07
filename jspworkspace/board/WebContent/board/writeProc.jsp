<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="article" scope="page" class="board.BoardDTO">
    <jsp:setProperty name="article" property="*"/>
</jsp:useBean>    
<%
    article.setRegdate( new Timestamp( System.currentTimeMillis() ) );
    article.setIp( request.getRemoteAddr() );
    BoardDAO dbPro = BoardDAO.getInstance();
    dbPro.insertArticle(article);
    response.sendRedirect("list.jsp");
%>