package com.furkanenes.oop.models;
import java.util.ArrayList;

public class Coupon {
	
	private String code;
	private int percent,price;
	private ArrayList<Category> categories;
	
	//Constructor
	public Coupon(String code, int percent, int price, ArrayList<Category> categories) {
		this.code = code;
		this.percent = percent;
		this.price = price;
		this.categories = categories;
	}

	//Getters&Setters
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void addCategory(Category c) {
		this.categories.add(c);
	}
	
	public void removeCategory(Category c) {
		Helper.removeFromList(this.categories, c);
	}
	
	//discount as price or percent 
	public boolean isPrice() {
		if(this.percent==0)
			return true;
		else
			return false;
	}
	
	//amount of discount
	public int amount() {	
		
		if(isPrice()==true)
			return this.price;
		else
			return this.percent;
	}
	
	
}
