package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/confirmDelete")
public class ConfirmDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmDeleteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserByEmail(request.getParameter("email"));
		
		System.out.println(user);
		
		ServiceFactory.getServiceFactory().getUserServiceImplementation().deleteUser(user);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("viewUser.jsp").forward(request, response);
		
	}

}
