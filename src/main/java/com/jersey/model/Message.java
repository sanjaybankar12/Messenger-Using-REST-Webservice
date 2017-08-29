package com.jersey.model;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Message {

	private int id;
	private String content;
	private Date created;
	private String author;
	private Map<Integer,Comment> comments=new HashMap<>();
	private List<Link> links=new ArrayList<>();
	
	public Message(){
		
	}
	
	public Message(int id, String content, Date created, String author) {
		super();
		this.id = id;
		this.content = content;
		this.created = created;
		this.author = author;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url,String rel)
	{
		Link link=new Link();
		link.setLink(url);
		link.setRel(rel);
		
		links.add(link);
	}
	
}
