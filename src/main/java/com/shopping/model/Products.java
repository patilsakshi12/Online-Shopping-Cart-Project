package com.shopping.model;

public class Products {
	private int productId;
    private String productName;
    private String description;
    private String category;
    private double price;
    private int quantity;
    private String image;
    
    public Products() {
    	
    }
    
    
	public Products(int productId, String productName, String description, String category, double price, int quantity,
			String image) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
    
    
}
