package com.agt.app.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agt.app.pojos.Cart;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getParameter("path");
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		float price = Float.parseFloat(request.getParameter("price"));
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
	
		price = price * quantity;

		Cart cart = new Cart(userId, bookId, quantity, price);
		
//		Cart existingCartItem = null; 
		
		if ((ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItemByUserIdAndBookId(userId, bookId))==null) {
			
			ServiceFactory.getServiceFactory().getOrderServiceImplementation().insertCartItem(cart);

		}
		
		else {
			
			ServiceFactory.getServiceFactory().getOrderServiceImplementation().updateCartItem(cart);

		}
		
		cart = ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItemByUserIdAndBookId(userId, bookId);
		
		request.setAttribute("cart", cart);

		request.getRequestDispatcher(path).forward(request, response);
		
	}

}