<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="article" scope="page" class="board.BoardDTO">
    <jsp:setProperty name="article" property="*"/>
</jsp:useBean>
<%
    String pageNum = request.getParameter("pageNum");
    BoardDAO dbProc = BoardDAO.getInstance();
    int check = dbProc.updateArticle(article);
    if(check == 1){
%>
    <meta http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%= pageNum %>">
<%    } else { %>
    <script>
    <!--
        alert("비밀번호가 맞지 않습니다.");
        history.go(-1);
    -->
    </script>
<%    } %>
