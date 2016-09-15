package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;
import framework.WebUtil;

public class UpdateController implements Controller {

	private BoardService service;
	public UpdateController() {
		service = new BoardServiceImpl();
	}
	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		Board board = new Board();
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		*/
		
		service.update(
			(Board)WebUtil.getParamToVO(Board.class, request)
		);
		
		return new ModelAndView("redirect:list.do");
	}
}











