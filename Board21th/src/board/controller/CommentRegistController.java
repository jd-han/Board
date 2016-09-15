package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.Comment;
import framework.Controller;

public class CommentRegistController implements Controller {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		Comment comment = new Comment();
		comment.setNo(no);
		comment.setContent(request.getParameter("content"));
		comment.setId(request.getParameter("id"));
		
		// 게시물 저장 처리 부탁..
		BoardDAO dao = new BoardDAO();
		dao.insertComment(comment);
		
		return "redirect:detail.do?no=" + no;
	}
}











