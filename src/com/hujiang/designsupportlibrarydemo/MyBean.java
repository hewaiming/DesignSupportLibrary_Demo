package com.hujiang.designsupportlibrarydemo;

public class MyBean {
	private String Title;
	private String Takes;
	private String Contents;
	private String Update;
	
	
	@Override
	public String toString() {
		return "MyBean [Title=" + Title + ", Takes=" + Takes + ", Contents=" + Contents + ", Update=" + Update + "]";
	}

	public MyBean() {
		super();
	}

	public MyBean(String title, String takes, String contents, String update) {
		super();
		Title = title;
		Takes = takes;
		Contents = contents;
		Update = update;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getTakes() {
		return Takes;
	}

	public void setTakes(String takes) {
		Takes = takes;
	}

	public String getContents() {
		return Contents;
	}

	public void setContents(String contents) {
		Contents = contents;
	}

	public String getUpdate() {
		return Update;
	}

	public void setUpdate(String update) {
		Update = update;
	}

}
