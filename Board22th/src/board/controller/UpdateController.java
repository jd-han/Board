package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;
import framework.Controller;
import framework.ModelAndView;

public class UpdateController implements Controller {

	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Board board = new Board();
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		BoardDAO dao = new BoardDAO();
		dao.updateBoard(board);
		return new ModelAndView("redirect:list.do");
	}
}











