package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agt.app.pojos.User;

@WebServlet("/userProfileClose")
public class UserProfileClose extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserProfileClose() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (((User) session.getAttribute("user")).getRole().equals("SuperAdmin")) {

			request.getRequestDispatcher("superAdminHome.jsp").forward(request, response);

		}

		else if (((User) session.getAttribute("user")).getRole().equals("Admin")) {

			request.getRequestDispatcher("adminHome.jsp").forward(request, response);

		}

		else {

			request.getRequestDispatcher("userHome.jsp").forward(request, response);

		}

	}

}
