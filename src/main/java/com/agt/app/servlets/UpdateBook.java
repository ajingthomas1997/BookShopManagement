package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.Book;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt((String) request.getParameter("id"));

		Book book = ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(bookId);
		
		int quantity = Integer.parseInt((String) request.getParameter("quantity"));
		
		int price = Integer.parseInt((String) request.getParameter("price"));
		
		book.setQuantity(quantity);
		
		book.setPrice(price);
		
		ServiceFactory.getServiceFactory().getBookServiceImplementation().updateBook(book);
		
		request.setAttribute("message", book.getTitle()+" quantity or price has been updated.!!");
		
		request.setAttribute("ok", "viewBookForAdmin.jsp");		
		
		request.getRequestDispatcher("popupBox.jsp").forward(request, response);
		
	}

}
