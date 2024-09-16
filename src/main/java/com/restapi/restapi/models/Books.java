package com.restapi.restapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Books {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@OneToOne(cascade = CascadeType.ALL)
@JsonManagedReference
private Title title;
private int price;
@Override
public String toString() {
	return "Books [id=" + id + ", title=" + title + ", price=" + price + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public Title getTitle() {
	return title;
}
public void setTitle(Title title) {
	this.title = title;
}
public Books(int id, Title title, int price) {
	super();
	this.id = id;
	this.title = title;
	this.price = price;
}
public Books() {
	super();
	// TODO Auto-generated constructor stub
}


}
