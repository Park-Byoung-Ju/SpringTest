package com.totra.spring.test.lifecycle;

public class Notice {

	private String title;
	
	private String user;
	
	private String content;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	
	public String getTitle() {
		return this.title;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getContent() {
		return this.content;
	}
}
