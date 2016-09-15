package board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import board.Board;
import board.BoardDAO;
import board.BoardFile;
import framework.Controller;
import util.BitFileRenamePolicy;

public class WriteController implements Controller {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		BoardDAO dao = new BoardDAO();
		int no = dao.insertBoard(board);
		
		/*
			no number(6) not null,
			ori_file_name varchar2(200) not null,
			real_file_name varchar2(200) not null,
			file_path varchar2(100) not null,
			file_size number not null
		 */
		File file = mRequest.getFile("attachFile");
		if (file != null) {
			String oriFileName = mRequest.getOriginalFileName("attachFile");
			String realFileName = mRequest.getFilesystemName("attachFile");
			long fileSize = file.length();
			
			BoardFile boardFile = new BoardFile();
			boardFile.setNo(no);
			boardFile.setOriFileName(oriFileName);
			boardFile.setRealFileName(realFileName);
			boardFile.setFilePath(datePath);
			boardFile.setFileSize(fileSize);
			
			dao.insertBoardFile(boardFile);
		}
		return "redirect:list.do";
	}
}











