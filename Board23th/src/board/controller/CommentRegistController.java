package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Comment;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class CommentRegistController implements Controller {
	private BoardService service;
	
	public CommentRegistController() {
		service = new BoardServiceImpl();
	}

	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		Comment comment = new Comment();
		comment.setNo(no);
		comment.setContent(request.getParameter("content"));
		comment.setId(request.getParameter("id"));
		
		service.registComment(comment);
		
		return new ModelAndView("redirect:detail.do?no=" + no);
	}
}











