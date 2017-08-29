package com.jersey.model;

import java.util.Date;

public class Comment {

	private int id;
	private String content;
	private String author;
	private Date created;
	
	public Comment()
	{
		
	}	
	public Comment(int id, String content, String author, Date created) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.created = created;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
