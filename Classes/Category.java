
import java.util.ArrayList;

public class Category {
	private String name;
	private Category parent;
	private ArrayList<Category> children;
	private ArrayList<Coupon> coupons;
	private ArrayList<Product> products;

	//Constuctor
	public Category(String name, Category parent, ArrayList<Category> children, ArrayList<Coupon> coupons,
			ArrayList<Product> products) {
		this.name = name;
		this.parent = parent;
		this.children = children;
		this.coupons = coupons;
		this.products = products;
	}

	//Getters&Setters	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Category getParent() {
		return parent;
	}


	public void setParent(Category parent) {
		this.parent = parent;
	}


	public ArrayList<Category> getChildren() {
		return children;
	}


	public void setChildren(ArrayList<Category> children) {
		this.children = children;
	}


	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}


	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}


	public ArrayList<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	//Add new coupon to category
	public void addCoupon(Coupon c) {
		c.addCategory(this);
		this.coupons.add(c);
	}

	//Remove new coupon from category
	public void removeCoupon(Coupon c) {
		c.removeCategory(this);
		Helper.removeFromList(this.coupons, c);
	}
	
	//Add new product to category
	public void addProduct(Product p) {
		this.products.add(p);
	}
		
	//Remove new product from category
	public void removeProduct(Product p) {
		Helper.removeFromList(this.products, p);
	}
	
	//Getting sub categories
	public ArrayList<Category> children() {
		return this.children();
	}
}
