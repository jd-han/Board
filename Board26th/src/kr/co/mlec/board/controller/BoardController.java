package kr.co.mlec.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import framework.ModelAndView;
import framework.RequestMapping;
import framework.WebUtil;
import kr.co.mlec.board.Board;
import kr.co.mlec.board.BoardFile;
import kr.co.mlec.board.Comment;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.util.BitFileRenamePolicy;

public class BoardController {
	private BoardService service;
	public BoardController() {
		this.service = new BoardServiceImpl();
	}

	@RequestMapping("/board/writeForm.do")
	public ModelAndView writeForm(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("writeForm.jsp");
	}
	
	@RequestMapping("/board/write.do")
	public ModelAndView write(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/upload");
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		// 파일 처리를 위한 API 클래스 호출
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				savePath, 
				1024 * 1024 * 10, 
				"UTF-8",
				new BitFileRenamePolicy()
		);
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		
		Board board = new Board();
		board.setTitle(mRequest.getParameter("title"))
		     .setWriter(mRequest.getParameter("writer"))
		     .setContent(mRequest.getParameter("content"));
		
		// 게시물 저장 처리 부탁..
		File file = mRequest.getFile("attachFile");
		BoardFile boardFile = null;
		if (file != null) {
			String oriFileName = mRequest.getOriginalFileName("attachFile");
			String realFileName = mRequest.getFilesystemName("attachFile");
			long fileSize = file.length();
			boardFile = new BoardFile();
			boardFile.setOriFileName(oriFileName);
			boardFile.setRealFileName(realFileName);
			boardFile.setFilePath(datePath);
			boardFile.setFileSize(fileSize);
		}
		service.write(board, boardFile);
		
		return new ModelAndView("redirect:list.do");
	}
	
	@RequestMapping("/board/updateForm.do")
	public ModelAndView updateForm(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = service.updateForm(no);
		ModelAndView mav = new ModelAndView("updateForm.jsp");
		mav.addAttribute("board", board);
		return mav;
	}
	
	@RequestMapping("/board/update.do")
	public ModelAndView update(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		service.update(
			(Board)WebUtil.getParamToVO(Board.class, request)
		);
		return new ModelAndView("redirect:list.do");
	}
	
	@RequestMapping("/board/list.do")
	public ModelAndView list(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Board> list = service.list();
		ModelAndView mav = new ModelAndView("list.jsp");
		mav.addAttribute("list", list);
		return mav;
	}
	
	@RequestMapping("/board/detail.do")
	public ModelAndView detail(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("detail.jsp");
		Map<String, Object> result = service.detail(
			Integer.parseInt(request.getParameter("no"))
		);
		mav.addAttribute("board", result.get("board"));
		mav.addAttribute("file", result.get("file"));
		return mav;
	}
	
	@RequestMapping("/board/delete.do")
	public ModelAndView delete(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		service.delete(no);
		return new ModelAndView("redirect:list.do");
	}
	
	@RequestMapping("/board/commentDelete.do")
	public ModelAndView commentDeleteAjax(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		service.deleteComment(commentNo);
		return new ModelAndView(
				"ajax:" + new Gson().toJson(
						service.listComment(no)
				)
		);
	}
	
	@RequestMapping("/board/commentList.do")
	public ModelAndView commentListAjax(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView(
				"ajax:" + new Gson().toJson(
						service.listComment(
								Integer.parseInt(request.getParameter("no"))
						)
				)
		);
	}
	
	@RequestMapping("/board/commentRegist.do")
	public ModelAndView commentRegistAjax(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		service.registComment(
			(Comment)WebUtil.getParamToVO(Comment.class, request)	
		);
		return new ModelAndView(
				"ajax:" + new Gson().toJson(
						service.listComment(no)
				)
		);
	}
	
	@RequestMapping("/board/commentUpdate.do")
	public ModelAndView commentUpdateAjax(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		service.updateComment(
			(Comment)WebUtil.getParamToVO(Comment.class, request)	
		);
		return new ModelAndView("ajax:{}");
	}
}
