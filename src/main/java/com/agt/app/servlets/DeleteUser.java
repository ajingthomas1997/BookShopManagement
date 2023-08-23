package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.Book;
import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		int userId = Integer.parseInt((String) request.getParameter("id"));

		User user = ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserById(userId);
		try {

			if (ServiceFactory.getServiceFactory().getUserServiceImplementation().deleteUser(user)) {

				request.setAttribute("message", "User has been Deleted.!!");

				request.setAttribute("ok", "viewUser.jsp");

				request.getRequestDispatcher("popupBox.jsp").forward(request, response);

			}

			else {

				request.setAttribute("message", "User has not Deleted.!!");

				request.setAttribute("ok", "viewUser.jsp");

				request.getRequestDispatcher("popupBox.jsp").forward(request, response);

			}
		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}

	}

}
