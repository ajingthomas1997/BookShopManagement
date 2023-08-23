package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.Book;
import com.agt.app.pojos.Cart;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/deleteCartItem")
public class DeleteCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("cartId"));

		Cart cart = ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItemByCartId(id);

		ServiceFactory.getServiceFactory().getOrderServiceImplementation().deleteCartItem(cart.getUserId(), cart.getBookId());

		request.getRequestDispatcher("viewCart.jsp").forward(request, response);
	
	}

}
