package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.Comment;
import framework.Controller;
import framework.ModelAndView;

public class CommentUpdateController implements Controller {

	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		Comment comment = new Comment();
		comment.setContent(request.getParameter("content"));
		comment.setCommentNo(commentNo);
		
		// 게시물 저장 처리 부탁..
		BoardDAO dao = new BoardDAO();
		dao.updateComment(comment);
		return new ModelAndView("redirect:detail.do?no=" + no);
	}
}











