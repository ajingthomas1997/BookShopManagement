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

@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		int bookId = Integer.parseInt((String) request.getParameter("id"));

		Book book = ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(bookId);

		if (ServiceFactory.getServiceFactory().getBookServiceImplementation().deleteBookById(bookId)) {

			try {

					request.setAttribute("message", book.getTitle() + " has been Deleted.!!");

					request.setAttribute("ok", "viewBookForAdmin.jsp");

					request.getRequestDispatcher("popupBox.jsp").forward(request, response);
				

			} catch (ServletException | IOException e) {

				e.printStackTrace();

			}

		}

	}

}
