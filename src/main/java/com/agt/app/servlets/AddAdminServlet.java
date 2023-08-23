package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/addAdmin")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddAdminServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");

		String dob = request.getParameter("dob");

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		String gender = request.getParameter("gender");

		String role = "Admin";

		long contactNumber = Long.parseLong(request.getParameter("contactNumber"));

		User user = new User(name, dob, email, password, gender, role, contactNumber);

		if ((ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserByEmail(email) == null)
				&& (ServiceFactory.getServiceFactory().getUserServiceImplementation().addAdmin(user))) {

			String message = "Admin added successfully!";

			request.setAttribute("message", message);
			
			request.setAttribute("ok", "viewAdmin.jsp");

			request.getRequestDispatcher("popupBox.jsp").forward(request, response);

		}

		else {

			request.setAttribute("message", "Admin already exist..");

			request.setAttribute("color", "blue");

			request.getRequestDispatcher("addAdmin.jsp").forward(request, response);

		}

	}

}
