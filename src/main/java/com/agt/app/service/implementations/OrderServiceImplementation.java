package com.agt.app.service.implementations;

import java.util.List;

import com.agt.app.dao.DatabaseServiceImplementation;
import com.agt.app.pojos.Cart;
import com.agt.app.pojos.Order;
import com.agt.app.service.interfaces.OrderService;

public class OrderServiceImplementation implements OrderService{
	
	DatabaseServiceImplementation databaseServiceImplementation = new DatabaseServiceImplementation();

	protected OrderServiceImplementation() {

	}
	
	@Override
	public boolean addOrder(Order order) {

		return databaseServiceImplementation.insertOrder(order)>0;
	}

	@Override
	public List<Order> getAllOrders() {

		return databaseServiceImplementation.getAllOrders();
	}

	@Override
	public List<Order> getOrderByUserId(int id) {

		return databaseServiceImplementation.getOrdersByUserId(id);
	}

	@Override
	public boolean deleteOrder(Order order) {

		return databaseServiceImplementation.deleteOrder(order)>0;
	}

	@Override
	public Order getOrderById(int id) {

		return databaseServiceImplementation.getOrderById(id);
	}

	@Override
	public List<Cart> getCartItems(int userId) {

		return databaseServiceImplementation.getCartItems(userId);
	}
	
	@Override
	public Cart getCartItemByCartId(int cartId) {

		return databaseServiceImplementation.getCartItemByCartId(cartId);
		
	}

	@Override
	public boolean updateCartItem(Cart cart) {

		return databaseServiceImplementation.updateCartItem(cart)>0;
	}

	@Override
	public boolean insertCartItem(Cart cart) {

		return databaseServiceImplementation.insertCartItem(cart)>0;
	}

	@Override
	public boolean deleteCartItem(int userId, int bookId) {

		return databaseServiceImplementation.deleteCartItem(userId, bookId)>0;
	}

	@Override
	public boolean deleteAllCartItemsByUserId(int userId) {

		return databaseServiceImplementation.deleteAllCartItemsByUserId(userId)>0;
	}

	@Override
	public Cart getCartItemByUserIdAndBookId(int userId, int bookId) {

		return databaseServiceImplementation.getCartItemByUserIdAndBookId(userId, bookId);
	}

}