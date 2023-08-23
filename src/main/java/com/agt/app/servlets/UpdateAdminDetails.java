package com.agt.app.servlets;

import java.io.IOException;
import java.net.UnknownServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.pojos.User;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/updateAdminDetails")
public class UpdateAdminDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt((String)request.getParameter("id"));
		
		User user = ServiceFactory.getServiceFactory().getUserServiceImplementation().getAdminById(id);

		user.setDob((String)request.getParameter("dob"));
		
		user.setContactNumber(Long.parseLong((String)request.getParameter("contactNumber")));

		user.setGender((String)request.getParameter("gender"));
		
		if (ServiceFactory.getServiceFactory().getUserServiceImplementation().updateAdmin(user)) {
			
			String message = "Admin details updated successfully!";

			request.setAttribute("message", message);
			
			request.setAttribute("ok", "viewAdmin.jsp");

			request.getRequestDispatcher("popupBox.jsp").forward(request, response);
			
		}
		

		
	}

}
