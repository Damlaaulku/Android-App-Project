package com.furkanenes.oop.models;

import java.util.ArrayList;


public class User {

	
	public static ArrayList<User> UserDatabase=new ArrayList<User>();
	
	
	// Attributes
	private int id;
	private String firstName, lastName, password, phone, email;
	private ArrayList<Address> addresses;
	private ArrayList<Product> favorites, cart;
	private ArrayList<Order> orders;
	private Stack browsingHistory;
	private CircularQueue invoices;
	
	
	// Constructors
	public User(int id, String firstName, String lastName, String password, String phone, String email) {
		this.id = id;
		this.update(firstName, lastName, password, phone, email);

		this.addresses=new ArrayList<Address>();
		this.favorites=new ArrayList<Product>();
		this.cart=new ArrayList<Product>();
		this.orders=new ArrayList<Order>();
		this.browsingHistory=new Stack(100);
		this.invoices=new CircularQueue(100);

		UserDatabase.add(this);
	}
	
	/*
	 * Methods
	 */
	
	// Update user data
	public void update(String firstName, String lastName, String password, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	
	// Add new address
	public void addAddress(String name, String city, String town, String quarter, String details) {
		Address inserted=new Address(name, city, town, quarter, details);
		this.addresses.add(inserted);
	}
	
	// Add a product to favorites
	public void addToFavorites(Product p) {
		this.favorites.add(p);
	}
	
	// Remove a product from favorites
	public void removeFromFavorites(Product p) {
		Helper.removeFromList(this.favorites, p);
	}
	
	// Add a product to cart
	public void addToCart(Product p) {
		this.cart.add(p);
	}
	
	// Remove a product from favorites
	public void removeFromCart(Product p) {
		Helper.removeFromList(this.cart, p);
	}
	
	
	// Remove all items from cart
	public void clearCart() {
		this.cart.clear();
	}
	
	// Remove all items from favorites
	public void clearFavorites() {
		this.favorites.clear();
	}
	
	
	// Calculate the total price of cart
	public float getCartPrice() {
		float total=0;
		
		for(Product p: this.cart) {
			total+=p.getPrice();
		}
		
		return total;
	}
	
	// Create a new order from current cart
	public Order createOrder(Cargo cargo, String paymentType, float cargoPrice, int discount, Address addr, Coupon c) {
		Order inserted=new Order(this.cart, cargoPrice, paymentType, cargo, discount, this, addr, c);
		this.orders.add(inserted);

		return inserted;
	}
	
	
	// Try to authenticate with a password
	public boolean authenticate(String password) {
		return this.password==password;
	}
	
	
	// Add product to browsing history
	public void addToBrowsed(Product p) {
		this.browsingHistory.Push(p);
	}
	
	// Return the previously browsed item
	public Product getBrowsed() {
		return (Product)this.browsingHistory.Pop();
	}
	
	// Get oldest invoice
	public Invoice getInvoice(){
		return (Invoice)this.invoices.Dequeue();
	}
	
	
	
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Product> getFavorites() {
		return favorites;
	}

	public ArrayList<Product> getCart() {
		return cart;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public CircularQueue getInvoices() {
		return invoices;
	}

	public Stack getBrowsingHistory(){return browsingHistory;}
	
	
	
	
	
	
}
