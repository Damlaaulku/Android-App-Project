package com.furkanenes.oop.models;
import java.util.ArrayList;

public class Sofa extends Product{

	private ArrayList<Material> bodyMaterials;
	private ArrayList<Material> seatMaterials;
	private boolean isL, hasLegs;
	private int personCapacity;
	
	// Constructors
	public Sofa(float price, String code, String name, String description, Brand brand, boolean isL, boolean hasLegs, int personCapacity) {
		super(price, code, name, description, brand);
		this.isL=isL;
		this.hasLegs=hasLegs;
		this.personCapacity=personCapacity;
		this.bodyMaterials=new ArrayList<Material>();
		this.seatMaterials=new ArrayList<Material>();
	}
	
	public Sofa(float price, String code, String name, String description, Brand brand) {
		this(price, code, name, description, brand, false, false, 1);
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
	public boolean isL() {
		return isL;
	}

	public void setIsL(boolean isL) {
		this.isL = isL;
	}
	
	public boolean hasLegs() {
		return hasLegs;
	}

	public void setHasLegs(boolean hasLegs) {
		this.hasLegs = hasLegs;
	}

	public int getPersonCapacity() {
		return personCapacity;
	}

	public void setPersonCapacity(int personCapacity) {
		this.personCapacity = personCapacity;
	}

	public ArrayList<Material> getBodyMaterials() {
		return bodyMaterials;
	}

	public ArrayList<Material> getSeatMaterials() {
		return seatMaterials;
	}

	
	
	

	
}
