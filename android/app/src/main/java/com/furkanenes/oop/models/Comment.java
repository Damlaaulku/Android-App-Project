package com.furkanenes.oop.models;

public class Comment {
	private int rating;
	private User user;
	private String title, content,date;
	private Product product;
	
	
	//Constructors
	public Comment(User user, int rating, String title, String content) {
		this.rating = rating;
		this.user = user;
		this.title = title;
		this.content = content;
	}

	//Overloading
	public Comment(int rating, User user, String title, String content, String date, Product product) {
		this.rating = rating;
		this.user = user;
		this.title = title;
		this.content = content;
		this.date = date;
		this.product = product;
	}

	//Getters&Setters
	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	

}
