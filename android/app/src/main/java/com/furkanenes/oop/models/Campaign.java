package com.furkanenes.oop.models;

import java.util.ArrayList;

public class Campaign {

	public static ArrayList<Campaign> CampaignDatabase=new ArrayList<Campaign>();

	private String name, start, end;
	private int percent;
	private ArrayList<Product> products;
	
	//Constructor
	public Campaign(String name, String start, String end, int percent) {
		this.name = name;
		this.start = start;
		this.end = end;
		this.percent = percent;
		this.products = new ArrayList<Product>();

		CampaignDatabase.add(this);
	}

	//Gettters&Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void addProduct(Product p) {

		this.products.add(p);
	}
	
	public void removeProduct(Product p) {
		Helper.removeFromList(this.products, p);
	}
	
	
}
