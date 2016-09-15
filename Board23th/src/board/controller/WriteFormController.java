package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class WriteFormController implements Controller {
	private BoardService service;
	public WriteFormController() {
		this.service = new BoardServiceImpl();
	}
	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("writeForm.jsp");
	}
}