package com.restapi.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Title {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String subTitle;
	
	@OneToOne(mappedBy = "title")
	@JsonBackReference
	private Books book;
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
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	
	public Title(int id, String title, String subTitle, Books book) {
		super();
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.book = book;
	}
	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
