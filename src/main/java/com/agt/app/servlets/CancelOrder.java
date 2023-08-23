package com.agt.app.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.Cart;
import com.agt.app.pojos.Order;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/cancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("cartId") != null) {

			int id = Integer.parseInt(request.getParameter("cartId"));

			Cart cart = ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItemByCartId(id);

//		ServiceFactory.getServiceFactory().getOrderServiceImplementation().deleteCartItem(cart.getUserId(),
//				cart.getBookId());

			request.setAttribute("message", "Order cancelled, Item has been moved to cart.!!");

		}

		else {

			int id = Integer.parseInt(request.getParameter("userId"));

			ServiceFactory.getServiceFactory().getOrderServiceImplementation().deleteAllCartItemsByUserId(id);

			request.setAttribute("message", "All items in cart has been removed.!!");
			
		}
		
		request.setAttribute("ok", "viewCart.jsp");

		request.getRequestDispatcher("popupBox.jsp").forward(request, response);

	}

}
