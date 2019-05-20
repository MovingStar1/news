package com.news.entity;

import java.util.Date;

public class News {
	private int id;
	private String title;
	private String content;
	private String autor;
	private Date date;
	private String type;
	public News() {
		// TODO Auto-generated constructor stub
	}
	public News(int id) {
		super();
		this.id=id;
	}
	public News(String title,String content,String autor,Date date,String type) {
		super();
		this.title = title;
		this.content = content;
		this.autor = autor;
		this.date=date;
		this.type = type;

	}
	public News(String title,String autor,String content,Date date,String type,int id) {
		super();
		this.title = title;
		this.content = content;
		this.autor = autor;
		this.type = type;
		this.id=id;
		this.date=date;

	}
	public News(int id, String title, String content, String autor,
			Date date, String type) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.autor = autor;
		this.date = date;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", autor=" + autor + ", date=" + date + ", type=" + type
				+ "]";
	}
	



}
