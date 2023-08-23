package com.agt.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/updateUserDetails")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		User user = ServiceFactory.getServiceFactory().getUserServiceImplementation()
				.getUserById(Integer.parseInt((String) request.getParameter("id")));

		user.setDob(request.getParameter("dob"));

		user.setGender(request.getParameter("gender"));

		long number = Long.parseLong(request.getParameter("contactNumber"));

		user.setContactNumber(number);

		ServiceFactory.getServiceFactory().getUserServiceImplementation().updateUser(user);

		try {

			request.setAttribute("message", "User Details Updated successfully.!!");

			request.setAttribute("ok", "viewUser.jsp");

			request.getRequestDispatcher("popupBox").forward(request, response);

		} catch (IOException | ServletException e) {

			e.printStackTrace();

		}

	}

}