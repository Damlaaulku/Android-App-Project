import java.util.ArrayList;

/*
 * The abstract class for all product types
 */
public abstract class Product {

	/*
	 * Static Operations
	 */
	public static ArrayList<Product> ProductDatabase=new ArrayList<Product>();
	
	// Search all product by a keyword and return result
	public static ArrayList<Product> search(String keyword) {
		ArrayList<Product> results=new ArrayList<Product>();
		
		// Iterate products
		for(Product p: ProductDatabase) {
			// Add to results if display string contains the keyword
			if(p.display().contains(keyword))
				results.add(p);
		}
		
		return results;
	}
	// end search
	
	
	
	/**************/
	
	
	// Attributes
	private float price;
	private String code, name, description;
	private Size size;
	private ArrayList<String> photos;
	private ArrayList<Comment> comments;
	private ArrayList<Category> categories;
	private ArrayList<Campaign> campaigns;
	private Brand brand;



	// Constructors
	public Product(float price, String code, String name, String description, Size size, ArrayList<Category> categories, Brand brand) {
		this.price = price;
		this.code = code;
		this.name = name;
		this.description = description;
		this.size = size;
		this.categories = categories;
		this.setBrand(brand);
		
		ProductDatabase.add(this);
	}
	
	public Product(float price, String code, String name, String description, Brand brand) {
		this(price, code, name, description, null, (new ArrayList<Category>()), brand);
	}
	
	

	// Add a category
	public void addToCategory(Category c) {
		c.addProduct(this);
		
		this.categories.add(c);
	}
	
	// Remove a category
	public void removeCategory(Category c) {
		c.removeProduct(this);
		Helper.removeFromList(this.categories, c);
	}
	
	// Add a comment
	public void addToComments(User u, int rating, String title, String comment) {
		Comment inserted=new Comment(u, rating, title, comment);
		this.comments.add(inserted);
	}
	
	// Remove a comment
	public void removeComment(Comment c) {
		Helper.removeFromList(this.comments, c);
	}
	
	// Get average rating of this product
	public float getRating() {
		float total=0, count=0;
		
		for(Comment c: this.comments) {
			total+=c.getRating();
			count++;
		}
		
		// Not to divide by zero
		if(count==0)
			return 0;
		
		return total/count;
	}
		

	// Add a photo
	public void addToPhotos(String p) {
		this.photos.add(p);
	}
	
	// Remove a photo
	public void removePhoto(String p) {
		Helper.removeFromList(this.photos, p);
	}
		
		
	// Add a campaign
	public void addToCampaigns(Campaign c) {
		c.addProduct(this);
		this.campaigns.add(c);
	}
	
	// Remove a campaign
	public void removeCampaign(Campaign c) {
		c.removeProduct(this);
		Helper.removeFromList(this.campaigns, c);
	}
		
	// Return general data about this product
	public String display() {
		String o="";
		
		o+=this.getCode()+"*";
		o+=this.getName()+"*";
		o+=this.getDescription()+"*";
		o+=this.getBrand().getName()+"*";
		
		for(Category c: categories)
			o+=c.getName()+"*";
		
		return o;
	}
	// end display
	

	
	
	// Getters & Setters
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Size getSize() {
		return size;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setBrand(Brand brand) {
		Brand oldBrand=this.brand;
		
		if(oldBrand!=null) {
			oldBrand.removeProduct(this);
		}
		
		this.brand = brand;
		
		this.brand.addProduct(this);
	}

	public ArrayList<String> getPhotos() {
		return photos;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public ArrayList<Campaign> getCampaigns() {
		return campaigns;
	}

	
	
	
	
	

	
}
