package board.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import board.Board;
import board.BoardFile;
import board.Comment;

public interface BoardService {
	/** 게시물의 목록 정보를 조회하는 기능 */
	public List<Board> list() throws Exception;
	
	/**  댓글 삭제 처리  */
	public void deleteComment(int commentNo) throws Exception;

	public void registComment(Comment comment) throws Exception;

	public void updateComment(Comment comment) throws Exception;

	public void delete(int no) throws Exception;

	public void update(Board board) throws Exception;

	public Board updateForm(int no) throws Exception;

	public Map<String, Object> detail(int findNo) throws Exception;

	public void write(Board board, BoardFile boardFile) throws Exception;

	public List<Comment> listComment(int no) throws Exception;
}









