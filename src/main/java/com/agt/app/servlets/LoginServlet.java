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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {

		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		User user = ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserByEmail(email);

		try {

			if (user != null) {

				if (user.getPassword().equals(password)) {

					HttpSession session = request.getSession();

					session.setAttribute("user", user);
					
					request.setAttribute("message",	"Login Successfull, Welcome " + user.getName() + "[" + user.getRole() + "]");

					if (user.getRole().equals("SuperAdmin")) {
						
						request.setAttribute("ok", "superAdminHome.jsp");

						request.getRequestDispatcher("popupBox.jsp").forward(request, response);

					}

					else if (user.getRole().equals("Admin")) {

						request.setAttribute("ok", "adminHome.jsp");

						request.getRequestDispatcher("popupBox.jsp").forward(request, response);

					}

					else {

						request.setAttribute("ok", "userHome.jsp");

						request.getRequestDispatcher("popupBox.jsp").forward(request, response);

					}

				}

				else {

					request.setAttribute("error", "Invaild Password!!");

					request.setAttribute("color", "red");

					request.getRequestDispatcher("login.jsp").forward(request, response);

				}

			} else {

				request.setAttribute("error", "Invaild Username!!");

				request.setAttribute("color", "red");

				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}
	}

}
