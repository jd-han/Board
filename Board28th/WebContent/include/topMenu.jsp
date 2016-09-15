<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:choose>
	<c:when test="${empty user}">
		<li><a href="${pageContext.request.contextPath}/login/loginForm.do">로그인</a></li>	
	</c:when>
	<c:otherwise>
		<li><a href="${pageContext.request.contextPath}/login/logout.do">로그아웃</a></li>	
	</c:otherwise>
</c:choose>    
	<li><a href="${pageContext.request.contextPath}/board/list.do">자유게시판</a></li>	
</ul>
<%--
   로그인 상태의 메뉴
   1. 로그아웃
   2. 자유게시판

   로그인이 안되어 있는 상태의 메뉴
   1. 로그인
   2. 자유게시판
--%>   