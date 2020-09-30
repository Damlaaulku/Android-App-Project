package com.furkanenes.oop.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {

	private int taxPercent;
	private float taxPrice,totalPrice, basePrice;
	private String issuedAt;
	private User user;
	private Order order;
	private ArrayList<Product> items;
	
	//Constructor
	public Invoice(int taxPercent, float basePrice, User user, Order order, ArrayList<Product> items) {
		this.taxPercent = taxPercent;
		this.basePrice = basePrice;
		this.issuedAt = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		this.user = user;
		this.order = order;
		this.items = items;
		
		this.calculatePrices();
	}

	//Getters&Setters
	public int getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(int taxPercent) {
		this.taxPercent = taxPercent;
	}

	public float getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(float taxPrice) {
		this.taxPrice = taxPrice;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public String getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ArrayList<Product> getItems() {
		return items;
	}

	public void setItems(ArrayList<Product> items) {
		this.items = items;
	}
	
	//Calculating final price
	public void calculatePrices() {
		
		float calculatedTaxPrice = this.basePrice*this.taxPercent/100;
		
		this.taxPrice = calculatedTaxPrice;
		
		this.totalPrice = this.taxPrice+this.basePrice;
		
	}
}
