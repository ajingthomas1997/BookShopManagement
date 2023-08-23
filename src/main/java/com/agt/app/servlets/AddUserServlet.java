package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUserServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");

		String dob = request.getParameter("dob");

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		String gender = request.getParameter("gender");

		String role = "User";

		long contactNumber = Long.parseLong(request.getParameter("contactNumber"));

		User user = new User(name, dob, email, password, gender, role, contactNumber);

		if ((ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserByEmail(email) == null)
				&& (ServiceFactory.getServiceFactory().getUserServiceImplementation().addUser(user))) {

			String message = "User added successfully!";

			request.setAttribute("message", message);
			
			request.setAttribute("ok", "viewUser.jsp");

			request.getRequestDispatcher("popupBox.jsp").forward(request, response);

		}

		else {

			request.setAttribute("message", "User already exist..");

			request.setAttribute("color", "blue");

			request.getRequestDispatcher("addUser.jsp").forward(request, response);

		}

	}

}
