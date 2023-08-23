package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/deleteProfilePicture")
public class DeleteProfilePictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProfilePictureServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		try {

			if (ServiceFactory.getServiceFactory().getUserServiceImplementation().deleteProfilePicture(user.getId())) {

				request.setAttribute("ok", "userProfile.jsp");

				request.setAttribute("message", "Profile Picture deleted Successfully.!!");

				request.getRequestDispatcher("popupBox.jsp").forward(request, response);

			}

		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}

	}
}