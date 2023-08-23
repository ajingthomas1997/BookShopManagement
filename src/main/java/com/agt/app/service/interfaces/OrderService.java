package com.agt.app.service.interfaces;

import java.util.List;

import com.agt.app.pojos.Cart;
import com.agt.app.pojos.Order;

public interface OrderService {

	public List<Order> getAllOrders();
	
	public List<Order> getOrderByUserId(int id);
	
	public Order getOrderById(int id);
	
	public boolean addOrder(Order order);

	public boolean deleteOrder(Order order);
	
	//cart operations
	public List<Cart> getCartItems(int userId);
	
	public Cart getCartItemByUserIdAndBookId(int userId, int bookId);
	
	public Cart getCartItemByCartId(int cartId);

	public boolean updateCartItem(Cart cart);

	public boolean insertCartItem(Cart cart);

	public boolean deleteCartItem(int userId, int bookId);

	public boolean deleteAllCartItemsByUserId(int userId);


	

}
