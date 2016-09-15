<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
		 <br><br>
		 <hr />
		 번호 : <c:out value="${param.no}" /><br>
		 글쓴이 : <c:out value="${board.writer}" /><br>
		 제목 : <c:out value="${board.title}" /><br>
		 내용 : <c:out value="${board.content}" /><br>
		 등록일시 : 
		 <fmt:formatDate var="regDate" value="${board.regDate}" 
		                 pattern="yyyy-MM-dd HH:mm:ss" />
		 <c:out value="${regDate}" /><br>
		 첨부파일 : 
		 <a href="${pageContext.request.contextPath}/down?path=${file.filePath}&realName=${file.realFileName}&oriName=${file.oriFileName}">${file.oriFileName}</a>(${file.fileSize} byte)
		 <hr />
		 <a href='updateForm.do?no=<c:out value="${param.no}" />'>수정</a>
		 <a href='delete.do?no=<c:out value="${param.no}" />'>삭제</a>
		<a href='list.do'>목록</a>
		
		<div id="comment">
			<form method="post" action="commentRegist.do">
				<input type="hidden" name="no" value="${board.no}" />	
				<input type="hidden" name="id" value="${user.id}" />	
				<table width="70%">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><textarea name="content" rows="2" cols="60"></textarea></td>
					<td><input type="submit" value="등록" /></td>
				</tr>	
				</table>
			</form>
		</div>
		
		<form action="commentUpdate.do" method="post">
			<input type="hidden" name="no" value="${board.no}" />
			<input type="hidden" name="commentNo" value="${commentNo}" />
		<div id="commentList">
			
		  <table width='80%' border='1'>
		  <tr>
			<c:forEach var="comment" items="${commentList}">
			<c:choose>
		  		<c:when test="${commentNo eq comment.commentNo}">	
					<tr>
					  <td><c:out value="${comment.id}" /></td>
					  <td>
					  	<textarea name="content" rows="2" cols="60"><c:out value="${comment.content}" /></textarea>
					  </td>
					  <td colspan="2">
					  	  <input type="submit" value="수정" />	
					  </td>
					 </tr>
			 	</c:when>
			 	<c:otherwise>
					<tr>
					  <td><c:out value="${comment.id}" /></td>
					  <td>
					  		<c:out value="${comment.content}" /></td>
					  <td><fmt:formatDate var="regDate" value="${comment.regDate}" 
					                      pattern="yyyy-MM-dd HH:mm:ss" />
					      <c:out value="${regDate}" />
					  </td>
					  <td>
					  	  <a href="commentDelete.do?commentNo=${comment.commentNo}&no=${comment.no}">삭제</a>	
					  	  <a href="detail.do?commentNo=${comment.commentNo}&no=${comment.no}">수정</a>	
					  </td>
					 </tr>
			 	</c:otherwise>
			 </c:choose>	
			 </c:forEach>
			 <c:if test="${empty commentList}">
			 <tr>
			    <td colspan='4'>댓글이 존재하지 않습니다.</td>
			 </tr>
		 	</c:if>
		 </table>
		</div>
		</form>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>

</body>
</html>




