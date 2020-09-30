package com.furkanenes.oop.models;

import java.util.ArrayList;

public class Brand {
	
	private String name;
	private ArrayList<Product> products;
	
	//Constructor
	public Brand(String name) {
		this.name = name;
		this.products = new ArrayList<Product>();
	}
	
	//Gettters&Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	//Remove product from product list
	public void removeProduct( Product p) {
		Helper.removeFromList(this.products, p);
	}
	
	//Add product to product list
	public void addProduct(Product p) {
		
		this.products.add(p);
		
	}
	
}
