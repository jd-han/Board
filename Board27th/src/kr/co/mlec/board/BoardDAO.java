/**
 *  DAO : Date Access Object
 *  insert 
 *  update
 *  delete
 *  select
 */
package kr.co.mlec.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.util.MyAppSqlConfig;

public class BoardDAO {
	private static SqlSession session = null;
	public BoardDAO () {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	public int insertBoard(Board board) {
		session.insert("board.BoardDAO.insertBoard", board);
		session.commit();
		return board.getNo();
	}
	public int updateBoard(Board board) {
		int cnt = session.update("board.BoardDAO.updateBoard", board);
		session.commit();
		return cnt;
	}
	
	public int deleteBoard(int delNo) {
		int cnt = session.delete("board.BoardDAO.deleteBoard", delNo);
		session.commit();
		return cnt;		
	}
	
	public List<Board> selectBoard() {
		return session.selectList("board.BoardDAO.selectBoard");
	}
	/**
	 * 매개변수에 해당하는 글번호의 게시물을 반환하는 기능
	 * @param no
	 * @return  null 이 반환될 경우 해당 번호의 게시물이 존재하지 않는경우
	 *          null 이 아닌값이 반환된 경우는 해당 번호의 게시물을 찾은 경우
	 */
	public Board selectBoardByNo(int findNo) {
		return session.selectOne(
				"board.BoardDAO.selectBoardByNo", findNo);
	}
	public void insertBoardFile(BoardFile boardFile) {
		session.insert("board.BoardDAO.insertBoardFile", boardFile);
		session.commit();
	}
	public BoardFile selectBoardFileByNo(int findNo) {
		return session.selectOne(
				"board.BoardDAO.selectBoardFileByNo", findNo);
	}
	public void insertComment(Comment comment) {
		session.insert("board.BoardDAO.insertComment", comment);
		session.commit();
	}
	public List<Comment> selectCommentByNo(int findNo) {
		return session.selectList("board.BoardDAO.selectCommentByNo", findNo);
	}
	public void deleteComment(int commentNo) {
		session.delete("board.BoardDAO.deleteComment", commentNo);
		session.commit();
	}
	public void updateComment(Comment comment) {
		session.update("board.BoardDAO.updateComment", comment);
		session.commit();
	}
}










