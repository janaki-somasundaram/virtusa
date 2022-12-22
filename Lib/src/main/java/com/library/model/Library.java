package com.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Library {
	@Id
	private int boookid;
	public int getBoookid() {
		return boookid;
	}
	private int quantity;
	public void setBoookid(int boookid) {
		this.boookid = boookid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	private String bookName,genre;
	
}
