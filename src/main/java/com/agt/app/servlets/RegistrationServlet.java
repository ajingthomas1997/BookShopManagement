package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");

		String dob = request.getParameter("dob");

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		String gender = request.getParameter("gender");

		String role = "User";

		long contactNumber = Long.parseLong(request.getParameter("contactNumber"));

		User user = new User(name, dob, email, password, gender, role, contactNumber);

		try {

			if ((ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserByEmail(email) == null)
					&& (ServiceFactory.getServiceFactory().getUserServiceImplementation().addAdmin(user))) {

				// Assuming you have successfully processed the form data and have a success
				// message.
				String message = "User added successfully!";

				request.setAttribute("message", message);
				
				request.setAttribute("ok", "login.jsp");
				
				request.getRequestDispatcher("popupBox.jsp").forward(request, response);

			}

			else {

				request.setAttribute("message", "User already exist..");

				request.setAttribute("color", "blue");

				request.getRequestDispatcher("registration.jsp").forward(request, response);

			}

		} catch (ServletException | IOException e) {

			e.printStackTrace();
		
		}
	}

}