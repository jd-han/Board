<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8'>
  <title>네트워크 게시판</title>
</head>
<body>
<div class="container">
	<div class="header">
		<%@ include file="/include/topMenu.jsp" %>
	</div>	
	<div class="content">
	  <h2>네트워크 게시판</h2>
	  전체 ${fn:length(list)}개<br>
	  <hr>
	  <table width='80%' border='1'>
	  <tr>
	    <th>번호</th>
	    <th>글쓴이</th>
	    <th>제목</th>
	    <th>등록일</th>
	    </tr>
		<c:forEach var="board" items="${list}">
		<tr>
		  <td><c:out value="${board.no}" /></td>
		  <td><c:out value="${board.writer}" /></td>
		  <td><a href='detail.do?no=<c:out value="${board.no}" />'><c:out value="${board.title}" /></a></td>
		  <td><fmt:formatDate var="regDate" value="${board.regDate}" pattern="yyyy-MM-dd" />
		      <c:out value="${regDate}" />
		  </td>
		 </tr>
		 </c:forEach>
		 <c:if test="${empty list}">
		 <tr>
		    <td colspan='4'>게시물이 존재하지 않습니다.</td>
		 </tr>
		 </c:if>
		 </table>
		 <a href='writeForm.do'>글쓰기</a>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>
</body>
</html>







