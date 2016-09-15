package board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class DetailController implements Controller {
	private BoardService service;
	
	public DetailController() {
		this.service = new BoardServiceImpl();
	}
	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("detail.jsp");
		Map<String, Object> result = service.detail(
			Integer.parseInt(request.getParameter("no"))
		);
		mav.addAttribute("board", result.get("board"));
		mav.addAttribute("file", result.get("file"));
		return mav;
	}
	
}











