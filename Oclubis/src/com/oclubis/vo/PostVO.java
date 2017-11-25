package com.oclubis.vo;

import java.sql.Date;

public class PostVO {
	private int number;
	private String theme;
	private String content;
	private String writer;
	private String date;
	private int category;

	public PostVO() {
		// TODO Auto-generated constructor stub
	}

	public PostVO(int number, String theme, String content, String writer, String date, int category) {
		this.number = number;
		this.theme = theme;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.category = category;
	}

	public PostVO(String theme, String content, String writer, String date, int category) {
		this.theme = theme;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.category = category;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

}
