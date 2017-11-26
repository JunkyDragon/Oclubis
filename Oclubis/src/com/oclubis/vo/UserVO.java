package com.oclubis.vo;

public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String club;
	private int permission;

	/*
	 * permission info 
	 * 0 : 일반 학생 
	 * 1 : 동아리장 
	 * 2 : 선생님 
	 * 3 : 어드민
	 */
	
	public UserVO() {
	}

	public UserVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public UserVO(String id, String pwd, String name, String club) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.club = club;
	}

	public UserVO(String id, String pwd, String name, String club, int permission) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.club = club;
		this.permission = permission;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

}
