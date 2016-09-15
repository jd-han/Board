package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class UpdateFormController implements Controller {

	private BoardService service;
	
	public UpdateFormController() {
		this.service = new BoardServiceImpl();
	}
	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = service.updateForm(no);
		ModelAndView mav = new ModelAndView("updateForm.jsp");
		mav.addAttribute("board", board);
		return mav;
	}
}











