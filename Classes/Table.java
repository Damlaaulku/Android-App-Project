
public class Table extends Product implements Materialable{

	private int numOfLegs;
	private boolean isExpandable;
	
	// Constructors
	public Table(float price, String code, String name, String description, Brand brand, int numOfLegs, boolean isExpandable) {
		super(price, code, name, description, brand);
		this.numOfLegs=numOfLegs;
		this.isExpandable=isExpandable;
	}
	
	public Table(float price, String code, String name, String description, Brand brand) {
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
	public int getNumOfLegs() {
		return numOfLegs;
	}

	public boolean isExpandable() {
		return isExpandable;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}

	public void setIsExpandable(boolean isExpandable) {
		this.isExpandable = isExpandable;
	}

	
}
