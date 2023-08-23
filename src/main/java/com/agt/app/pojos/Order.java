package com.agt.app.pojos;

public class Order {

    private int orderId;
    private int userId;
    private int bookId;
    private int quantity;
    private float totalPrice;
    private String orderDate;

    public Order() {
    }

    public Order(int orderId, int userId, int bookId, int quantity, float totalPrice, String orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.totalPrice=totalPrice;
        this.orderId=orderId;
    }

    public Order(int userId, int bookId, int quantity, float totalPrice, String orderDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.totalPrice=totalPrice;
        this.orderDate=orderDate;
    }
    
    public Order(int userId, int bookId, int quantity, float price) {
    	this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.totalPrice=price;
    }

	public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                 ", totalPrice=" + totalPrice +
                  ", orderDate=" + orderDate +
                '}';
    }
}