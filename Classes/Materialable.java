import java.util.ArrayList;

public interface Materialable {

	// The material list
	public ArrayList<Material> materials=new ArrayList<Material>();
	
	// Add new material
	public void addMaterial(Material m);
	
	// Remove a material
	public void removeMaterial(Material m);
	
	
}
