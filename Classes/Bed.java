import java.util.ArrayList;

public class Bed extends Product{

	private ArrayList<Material> bodyMaterials;
	private ArrayList<Material> seatMaterials;
	private int capacity;
	
	// Constructors
	public Bed(float price, String code, String name, String description, Brand brand, int capacity) {
		super(price, code, name, description, brand);
		this.capacity=capacity;
	}
	
	public Bed(float price, String code, String name, String description, Brand brand) {
		this(price, code, name, description, brand, 1);
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
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public ArrayList<Material> getBodyMaterials() {
		return bodyMaterials;
	}

	public ArrayList<Material> getSeatMaterials() {
		return seatMaterials;
	}


	
}
