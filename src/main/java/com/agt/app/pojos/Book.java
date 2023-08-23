package com.agt.app.pojos;

public class Book {

	private int id;

	private String title;

	private String author;

	private String category;

	private int quantity;

	private double price;
	
	private String image;

	// Constructors (you can have multiple constructors if needed)
	public Book() {
		// Default constructor
	}

	public Book(int id, String title, String author, String category, int quantity, double price, String image) {

		this.id = id;

		this.title = title;

		this.author = author;

		this.category = category;

		this.quantity = quantity;

		this.price = price;
		
		this.image = image;

	}

	public Book(String title, String author, String category, int quantity, double price, String image) {

		this.title = title;

		this.author = author;

		this.category = category;

		this.quantity = quantity;

		this.price = price;
		
		this.image = image;

	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setImage(String image) {
		this.category = image;
	}

	public String getImage() {
		return image;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", quantity=" + quantity + ", price="
				+ price + ", category=" + category +", image=" + image + "]";
	}

}