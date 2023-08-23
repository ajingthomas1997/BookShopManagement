package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.Book;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddBookServlet() {

		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		String title = (String) request.getParameter("title");

		String author = (String) request.getParameter("author");

		String category = (String) request.getParameter("category");

		int quantity = Integer.parseInt((String) request.getParameter("quantity"));

		int price = Integer.parseInt((String) request.getParameter("price"));
		
		String image = (String) request.getParameter("image");

		Book book = new Book(title, author, category, quantity, price, image);

		ServiceFactory.getServiceFactory().getBookServiceImplementation().addBook(book);

		try {

			request.setAttribute("message", book.getTitle() + " has been Deleted.!!");

			request.setAttribute("ok", "viewBookForAdmin.jsp");

			request.getRequestDispatcher("popupBox.jsp").forward(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}

	}

}
