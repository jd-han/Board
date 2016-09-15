package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;
import board.BoardFile;
import board.Comment;
import framework.Controller;

public class DetailController implements Controller {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int findNo = Integer.parseInt(request.getParameter("no"));
		try {
			request.setAttribute(
					"commentNo", Integer.parseInt(
							request.getParameter("commentNo")));	
		} catch (NumberFormatException e) { }
		
		BoardDAO dao = new BoardDAO();
		Board board = dao.selectBoardByNo(findNo);
		
		// 게시물과 연관된 파일 정보 추출
		BoardFile file = dao.selectBoardFileByNo(findNo);
		
		request.setAttribute("board", board);
		// 파일 정보 공유
		request.setAttribute("file", file);
		// 파일 정보 공유
		request.setAttribute("file", file);
		
		// 댓글 목록 정보 공유
		List<Comment> commentList = dao.selectCommentByNo(findNo);
		request.setAttribute("commentList", commentList);
		
		return "detail.jsp";
	}
	
}











