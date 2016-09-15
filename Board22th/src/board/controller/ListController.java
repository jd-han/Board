package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;
import framework.Controller;
import framework.ModelAndView;

public class ListController implements Controller {

	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.selectBoard();
		ModelAndView mav = new ModelAndView("list.jsp");
		mav.addAttribute("list", list);
		return mav;
	}
	
}











