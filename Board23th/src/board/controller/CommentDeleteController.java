package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class CommentDeleteController implements Controller {
	private BoardService service;
	
	public CommentDeleteController() {
		this.service = new BoardServiceImpl();
	}

	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		service.deleteComment(commentNo);
		
		return new ModelAndView("redirect:detail.do?no=" + no);
	}
}











