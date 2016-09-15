package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import framework.Controller;

public class CommentDeleteController implements Controller {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteComment(commentNo);
		
		return "redirect:detail.do?no=" + no;
	}
}











