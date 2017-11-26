package com.oclubis.vo;

public class ClubVO {
	private String name;
	private String president;
	private String intro;

	public ClubVO() {}

	public ClubVO(String name, String president) {
		this.name = name;
		this.president = president;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
