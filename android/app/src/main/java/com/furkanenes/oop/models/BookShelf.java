package com.furkanenes.oop.models;

public class BookShelf extends Product implements Materialable{

	private int numOfShelves;
	private boolean hasLegs;
	
	// Constructors
	public BookShelf(float price, String code, String name, String description, Brand brand, int numOfShelves, boolean hasLegs) {
		super(price, code, name, description, brand);
		this.numOfShelves=numOfShelves;
		this.hasLegs=hasLegs;
	}
	
	public BookShelf(float price, String code, String name, String description, Brand brand) {
		this(price, code, name, description, brand, 0, false);
	}

	// Overrides
	@Override
	public void addMaterial(Material m) {
		materials.add(m);
	}

	@Override
	public void removeMaterial(Material m) {
		Helper.removeFromList(materials, m);
	}

	// Getters & Setters
	public int getNumOfShelves() {
		return numOfShelves;
	}

	public boolean isHasLegs() {
		return hasLegs;
	}

	public void setNumOfShelves(int numOfShelves) {
		this.numOfShelves = numOfShelves;
	}

	public void setHasLegs(boolean hasLegs) {
		this.hasLegs = hasLegs;
	}

	
}
