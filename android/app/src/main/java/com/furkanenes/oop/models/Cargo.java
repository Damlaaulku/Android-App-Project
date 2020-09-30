package com.furkanenes.oop.models;

import java.util.ArrayList;
import java.util.Random;

public class Cargo {

	public static ArrayList<Cargo> CargoDatabase=new ArrayList<Cargo>();

	private String firmName,url;
	private float price;
	
	//Constructor
	public Cargo(String firmName, String url, float price) {
		this.firmName = firmName;
		this.url = url;
		this.price = price;

		CargoDatabase.add(this);
	}

	//Getters&Setters
	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	// Generating the cargo code
	public static String generateCargoCode() {
		Random rnd = new Random();
		String code="";
		
		for (int i = 0; i < 10; i++) {
			int num = rnd.nextInt(10);
			code +=num;
		}
		
		return code;
		
	}
}
