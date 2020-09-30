
public class Wardrobe extends Product implements Materialable{

	private int numOfCabinets;
	private boolean hasLegs;
	
	// Constructors
	public Wardrobe(float price, String code, String name, String description, Brand brand, int numOfCabinets, boolean hasLegs) {
		super(price, code, name, description, brand);
		this.numOfCabinets=numOfCabinets;
		this.hasLegs=hasLegs;
	}
	
	public Wardrobe(float price, String code, String name, String description, Brand brand) {
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
	public int getNumOfCabinets() {
		return numOfCabinets;
	}

	public boolean isHasLegs() {
		return hasLegs;
	}

	public void setNumOfCabinets(int numOfCabinets) {
		this.numOfCabinets = numOfCabinets;
	}

	public void setHasLegs(boolean hasLegs) {
		this.hasLegs = hasLegs;
	}

	
}
