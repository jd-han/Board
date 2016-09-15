package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class ListController implements Controller {
	private BoardService service;
	public ListController() {
		service = new BoardServiceImpl();
	}
	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Board> list = service.list();
		ModelAndView mav = new ModelAndView("list.jsp");
		mav.addAttribute("list", list);
		return mav;
	}
	
}











