package board;

/*
 * 	file_no number primary key,
	no number(6) not null,
	ori_file_name varchar2(200) not null,
	real_file_name varchar2(200) not null,
	file_path varchar2(100) not null,
	file_size number not null
 */
public class BoardFile {
	private int fileNo;
	private int no;
	private String oriFileName;
	private String realFileName;
	private String filePath;
	private long fileSize;
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOriFileName() {
		return oriFileName;
	}
	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}








