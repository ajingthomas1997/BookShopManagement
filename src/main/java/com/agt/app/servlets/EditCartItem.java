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

/**
 * Servlet implementation class EditCartItem
 */
@WebServlet("/editCartItem")
public class EditCartItem extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("cartId"));

		Cart cart = ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItemByCartId(id);

		Book book = ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(cart.getBookId());

		request.setAttribute("book", book);
		
		request.setAttribute("header", "Update Quantity");
		
		request.setAttribute("button", "update");

		request.setAttribute("path", "viewCart.jsp");

		try {

			request.getRequestDispatcher("addToCart.jsp").forward(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}

	}

}
