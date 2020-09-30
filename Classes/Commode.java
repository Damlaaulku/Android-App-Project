
public class Commode extends Product implements Materialable{

	private int numOfDrawers;
	private boolean hasLegs;
	
	// Constructors
	public Commode(float price, String code, String name, String description, Brand brand, int numOfDrawers, boolean hasLegs) {
		super(price, code, name, description, brand);
		this.numOfDrawers=numOfDrawers;
		this.hasLegs=hasLegs;
	}
	
	public Commode(float price, String code, String name, String description, Brand brand) {
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
	public int getNumOfDrawers() {
		return numOfDrawers;
	}

	public boolean isHasLegs() {
		return hasLegs;
	}

	public void setNumOfDrawers(int numOfDrawers) {
		this.numOfDrawers = numOfDrawers;
	}

	public void setHasLegs(boolean hasLegs) {
		this.hasLegs = hasLegs;
	}

	
}
