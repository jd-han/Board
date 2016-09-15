package kr.co.mlec.board.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mlec.board.Board;
import kr.co.mlec.board.BoardDAO;
import kr.co.mlec.board.BoardFile;
import kr.co.mlec.board.Comment;

public class BoardServiceImpl implements BoardService {
	private BoardDAO dao;
	public BoardServiceImpl() {
		dao = new BoardDAO();
	}
	@Override
	public List<Board> list() throws Exception {
		return dao.selectBoard();
	}
	@Override
	public void deleteComment(int commentNo) throws Exception {
		dao.deleteComment(commentNo);		
	}
	@Override
	public void registComment(Comment comment) throws Exception {
		dao.insertComment(comment);
	}
	@Override
	public void updateComment(Comment comment) throws Exception {
		dao.updateComment(comment);
	}
	@Override
	public void delete(int no) throws Exception {
		dao.deleteBoard(no);
	}
	@Override
	public void update(Board board) throws Exception {
		dao.updateBoard(board);
	}
	@Override
	public Board updateForm(int no) throws Exception {
		return dao.selectBoardByNo(no);
	}
	
	@Override
	public Map<String, Object> detail(int findNo) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("board", dao.selectBoardByNo(findNo));
		// 게시물과 연관된 파일 정보 추출
		result.put("file", dao.selectBoardFileByNo(findNo));
		return result;
	}
	@Override
	public void write(Board board, BoardFile boardFile) throws Exception {
		int no = dao.insertBoard(board);
		if (boardFile != null) {
			boardFile.setNo(no);
			dao.insertBoardFile(boardFile);
		}
	}
	
	@Override
	public List<Comment> listComment(int no) throws Exception {
		return dao.selectCommentByNo(no);
	}
}









