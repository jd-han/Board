package kr.co.mlec.board;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {
	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	public int getNo() {
		return no;
	}
	public Board setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Board setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getWriter() {
		return writer;
	}
	public Board setWriter(String writer) {
		this.writer = writer;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Board setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Board setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}
	// toString 생성 단축키
	// alt + shift + s, s
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
}










