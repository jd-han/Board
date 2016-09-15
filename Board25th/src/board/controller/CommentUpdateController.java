package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Comment;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;
import framework.WebUtil;

public class CommentUpdateController implements Controller {

	private BoardService service;
	
	public CommentUpdateController() {
		this.service = new BoardServiceImpl();
	}
	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 게시판과 파일 테이블에 저장할 글번호를 조회
		/*
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		Comment comment = new Comment();
		comment.setContent(request.getParameter("content"));
		comment.setCommentNo(commentNo);
		service.updateComment(comment);
		 */
		service.updateComment(
			(Comment)WebUtil.getParamToVO(Comment.class, request)	
		);
		
		return new ModelAndView("ajax:{}");
	}
}











