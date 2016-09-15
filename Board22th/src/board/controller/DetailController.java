package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;
import board.BoardFile;
import board.Comment;
import framework.Controller;
import framework.ModelAndView;

public class DetailController implements Controller {

	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("detail.jsp");
		int findNo = Integer.parseInt(request.getParameter("no"));
		try {
			mav.addAttribute(
					"commentNo", Integer.parseInt(
							request.getParameter("commentNo")));	
		} catch (NumberFormatException e) { }
		
		BoardDAO dao = new BoardDAO();
		Board board = dao.selectBoardByNo(findNo);
		
		// 게시물과 연관된 파일 정보 추출
		BoardFile file = dao.selectBoardFileByNo(findNo);
		
		// 댓글 목록 정보 공유
		List<Comment> commentList = dao.selectCommentByNo(findNo);
		
		mav.addAttribute("board", board);
		mav.addAttribute("file", file);
		mav.addAttribute("commentList", commentList);
		return mav;
	}
	
}











