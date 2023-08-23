package com.agt.app.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.Cart;
import com.agt.app.pojos.Order;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/placeOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("cartId") != null) {
			int id = Integer.parseInt(request.getParameter("cartId"));

			Cart cart = ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItemByCartId(id);

			Order order = new Order(cart.getUserId(), cart.getBookId(), cart.getQuantity(), cart.getPrice());

			ServiceFactory.getServiceFactory().getOrderServiceImplementation().addOrder(order);

			ServiceFactory.getServiceFactory().getBookServiceImplementation().updateBookQuantityById(order.getBookId(),
					ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(order.getBookId())
							.getQuantity() - order.getQuantity());

			ServiceFactory.getServiceFactory().getOrderServiceImplementation().deleteCartItem(cart.getUserId(),
					cart.getBookId());

		}

		else {

			int id = Integer.parseInt(request.getParameter("userId"));

			List<Cart> carts = ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItems(id);

			for (Cart cart : carts) {

				if (cart.getQuantity() <= ServiceFactory.getServiceFactory().getBookServiceImplementation()
						.getBookById(cart.getBookId()).getQuantity()) {

					Order order = new Order(cart.getUserId(), cart.getBookId(), cart.getQuantity(), cart.getPrice());

					ServiceFactory.getServiceFactory().getOrderServiceImplementation().addOrder(order);

					ServiceFactory.getServiceFactory().getBookServiceImplementation().updateBookQuantityById(
							order.getBookId(), ServiceFactory.getServiceFactory().getBookServiceImplementation()
									.getBookById(order.getBookId()).getQuantity() - order.getQuantity());

					ServiceFactory.getServiceFactory().getOrderServiceImplementation().deleteCartItem(cart.getUserId(),
							cart.getBookId());

				}

			}

		}

		request.setAttribute("message", "Order Placed Successfully!!");

		request.setAttribute("ok", "viewOrdersForUser.jsp");

		request.getRequestDispatcher("popupBox.jsp").forward(request, response);

	}

}