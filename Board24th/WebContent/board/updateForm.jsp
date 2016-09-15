<%@page import="board.Board"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8'>
</head>
<body>
<div class="container">
	<div class="header">
		<%@ include file="/include/topMenu.jsp" %>
	</div>	
	<div class="content">
		 <hr />
		 <h2>자바 네트워크 게시판</h2>
		 <hr />
		 <form method='post' action='update.do'>
		   <input type='hidden' name='no' value='<c:out value="${param.no}" />' />
		    제목 : <input type='text' name='title' size='70' value='<c:out value="${board.title}" />' /><br>
		    글쓴이 : <input type='text' name='writer' size='30' readonly value='<c:out value="${board.writer}" />' /><br>
		    내용 : <textarea name='content' rows='7' cols='70'><c:out value="${board.content}" /></textarea><br>
		   <button type='submit'>수정</button>
		 </form>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>
</body>
</html>





