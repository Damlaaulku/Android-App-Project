package com.furkanenes.oop.models;
import java.util.ArrayList;

public class Chair extends Product{

	private ArrayList<Material> bodyMaterials;
	private ArrayList<Material> seatMaterials;
	private boolean isTurn;
	
	// Constructors
	public Chair(float price, String code, String name, String description, Brand brand, boolean isTurn) {
		super(price, code, name, description, brand);
		this.isTurn=isTurn;
		this.bodyMaterials=new ArrayList<Material>();
		this.seatMaterials=new ArrayList<Material>();
	}
	
	public Chair(float price, String code, String name, String description, Brand brand) {
		this(price, code, name, description, brand, false);
	}

	// Overrides
	public void addBodyMaterial(Material m) {
		this.bodyMaterials.add(m);
	}

	public void removeBodyMaterial(Material m) {
		Helper.removeFromList(this.bodyMaterials, m);
	}
	
	public void addSeatMaterial(Material m) {
		this.seatMaterials.add(m);
	}

	public void removeSeatMaterial(Material m) {
		Helper.removeFromList(this.seatMaterials, m);
	}

	// Getters & Setters
	public boolean isTurn() {
		return isTurn;
	}

	public void setIsTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	
	public ArrayList<Material> getBodyMaterials() {
		return bodyMaterials;
	}

	public ArrayList<Material> getSeatMaterials() {
		return seatMaterials;
	}


	
}
