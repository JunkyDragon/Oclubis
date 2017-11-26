package com.oclubis.vo;

public class CommentVO {
	private int postnum;
	private String content;
	private String writer;
	private String date;

	public CommentVO() { }

	public CommentVO(int postnum, String content, String writer) {
		super();
		this.postnum = postnum;
		this.content = content;
		this.writer = writer;
	}

	public int getPostnum() {
		return postnum;
	}

	public void setPostnum(int postnum) {
		this.postnum = postnum;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
