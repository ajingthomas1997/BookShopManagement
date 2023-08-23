package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agt.app.pojos.Book;
import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;
import com.mysql.cj.Session;

@WebServlet("/getBookDetailsForCart")
public class GetBookDetailsForCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("bookId"));

		Book book = ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(id);

		request.setAttribute("book", book);
		
		request.setAttribute("header", "Add To Cart");
		
		request.setAttribute("button", "Add");
		
		request.setAttribute("path", "viewCart.jsp");

		try {

			request.getRequestDispatcher("addToCart.jsp").forward(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}

	}

}