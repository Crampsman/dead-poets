package com.DeadPoets.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	public Post(){
		this.current_date = new Timestamp(new Date().getTime());
	}
	
	public Post(Writer writer){
		this.current_date = new Timestamp(new Date().getTime());
		this.writer = writer;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long post_id;
	
	@ManyToOne
	@JoinColumn(name = "writer_id")
	private Writer writer;
	
	@Column(name = "title")
	private String title = "* * *";
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "curdate")
	private Timestamp current_date;
	
	@Column(name = "showPost")
	private boolean showPost;
	
	
	public Long getPost_id() {
		return post_id;
	}



	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}



	public Writer getWriter() {
		return writer;
	}



	public void setWriter(Writer writer) {
		this.writer = writer;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}
	
	



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Timestamp getCurrent_date() {
		return current_date;
	}



	public void setCurrent_date(Timestamp current_date) {
		this.current_date = current_date;
	}

	
	public boolean getShowPost() {
		return showPost;
	}

	
	public void setShowPost(boolean showPost) {
		this.showPost = showPost;
	}
	
	
}
