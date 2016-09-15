package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;
import framework.Controller;

public class UpdateFormController implements Controller {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		Board board = dao.selectBoardByNo(no);
		request.setAttribute("board", board);
		return "updateForm.jsp";
	}
}











