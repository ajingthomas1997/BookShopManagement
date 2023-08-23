package com.agt.app.pojos;

public class Cart {

	private int cartId;

	private int userId;

	private int bookId;

	private int quantity;

	private float price;

	public Cart(int cartId, int userId, int bookId, int quantity, float price) {

		this.cartId = cartId;

		this.userId = userId;

		this.bookId = bookId;

		this.quantity = quantity;

		this.price = price;

	}

	public Cart(int userId, int bookId, int quantity, float price) {

		this.userId = userId;

		this.bookId = bookId;

		this.quantity = quantity;

		this.price = price;

	}

	public int getCartId() {

		return cartId;

	}

	public void setCartId(int cartId) {

		this.cartId = cartId;

	}

	public int getUserId() {

		return userId;

	}

	public void setUserId(int userId) {

		this.userId = userId;

	}

	public int getBookId() {

		return bookId;

	}

	public void setBookId(int bookId) {

		this.bookId = bookId;

	}

	public int getQuantity() {

		return quantity;

	}

	public void setQuantity(int quantity) {

		this.quantity = quantity;

	}

	public float getPrice() {

		return price;

	}

	public void setPrice(float price) {

		this.price = price;

	}

	@Override
	public String toString() {

		return "Cart [cartId=" + cartId + ", userId=" + userId + ", bookId=" + bookId + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}
