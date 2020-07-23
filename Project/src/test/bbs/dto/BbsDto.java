package test.bbs.dto;

public class BbsDto {
	private int num;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	
	public BbsDto() {}

	public BbsDto(int num, String title, String content, String writer, String regdate) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
