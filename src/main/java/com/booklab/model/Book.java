package com.booklab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
@Id	
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String category;
private String author;
private String image;
private double price;
private String sumary;

public Book() {
	super();
}

public Book(int id, String name, String category, String author, String image, double price, String sumary) {
	super();
	this.id = id;
	this.name = name;
	this.category = category;
	this.author = author;
	this.image = image;
	this.price = price;
	this.sumary = sumary;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getSumary() {
	return sumary;
}

public void setSumary(String sumary) {
	this.sumary = sumary;
}

@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", category=" + category + ", author=" + author + ", image=" + image
			+ ", price=" + price + ", sumary=" + sumary + "]";
}

}
