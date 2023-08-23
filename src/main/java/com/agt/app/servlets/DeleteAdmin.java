package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/deleteAdmin")
public class DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int adminId = Integer.parseInt((String) request.getParameter("id"));

		User user = ServiceFactory.getServiceFactory().getUserServiceImplementation().getAdminById(adminId);

		if (ServiceFactory.getServiceFactory().getUserServiceImplementation().deleteAdmin(user)) {

			try {

					request.setAttribute("message", user.getName() + " has been Deleted Successfully.!!");

					request.setAttribute("ok", "viewAdmin.jsp");

					request.getRequestDispatcher("popupBox.jsp").forward(request, response);
				

			} catch (ServletException | IOException e) {

				e.printStackTrace();

			}

		}
		
	}

}
