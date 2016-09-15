<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		 <form method='post' action='write.do'
		       encType="multipart/form-data">
		    제목 : <input type='text' name='title' size='70' /><br>
		    글쓴이 : <input type='text' name='writer' size='30' /><br>
		    내용 : <textarea name='content' rows='7' cols='70'></textarea><br>
		    첨부파일 : <input type="file" name="attachFile" /><br>
		   <button type='submit'>등록</button>
		 </form>
	</div>
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>
</body>
</html>