package com.furkanenes.oop.models;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Order {

	public static ArrayList<Order> OrderDatabase=new ArrayList<Order>();

	private ArrayList<Product> products;
	private float productTotal, cargoPrice, totalPrice;
	private String paymentType, status, createdAt, cargoCode;
	private Cargo cargo;
	private int discount;
	private User user;
	private Address address;
	private Coupon coupon;
	private Invoice invoice;
	
	/*
	 * Order Lifecycle (Status):
	 * 	init
	 * 	approved
	 * 	preparing
	 * 	delivery
	 * 	delivered | canceled
	 */
	
	// Constructors
	public Order(ArrayList<Product> products, float cargoPrice, String paymentType, Cargo cargo, int discount, User user, Address address, Coupon coupon) {
		this.products=products;
		this.cargoPrice = cargoPrice;
		this.paymentType = paymentType;
		this.cargo = cargo;
		this.discount = discount;
		this.user = user;
		this.address = address;
		this.coupon = coupon;


		Calendar calendar= Calendar.getInstance();;
		SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");;
		String date=dateFormat.format(calendar.getTime());;
		this.createdAt=date;

		Random r=new Random();
		this.cargoCode="DEU"+(r.nextInt()*1000);


		this.calculatePrices();
		this.status="init";

		OrderDatabase.add(this);
	}

	
	
	// Add new product
	public void addProduct(Product p) {
		this.products.add(p);
	}
	
	
	// Re-Calculate all prices
	private void calculatePrices() {
		float total=0;
		
		for(Product p: this.products) {
			total+=p.getPrice();
		}
		

		this.productTotal=total;
		this.totalPrice=productTotal + cargoPrice;
	}
	
	
	// Cancel order
	public void cancel() {
		this.status="canceled";
	}

	
	// Create an invoice from this order
	public void createInvoice(int taxPercent)
	{
		Invoice inserted=new Invoice(taxPercent, this.totalPrice, this.user, this, this.products);
		
		this.invoice=inserted;
	}
	
	
	
	// Getters & Setters
	public ArrayList<Product> getProducts(){
		return products;
	}
	
	public float getProductTotal() {
		return productTotal;
	}
	public float getCargoPrice() {
		return cargoPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public String getStatus() {
		return status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public String getCargoCode() {
		return cargoCode;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public int getDiscount() {
		return discount;
	}
	public User getUser() {
		return user;
	}
	public Address getAddress() {
		return address;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setProductTotal(float productTotal) {
		this.productTotal = productTotal;
	}
	public void setCargoPrice(float cargoPrice) {
		this.cargoPrice = cargoPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public void setCargoCode(String cargoCode) {
		this.cargoCode = cargoCode;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	
	
	
	
	
}
