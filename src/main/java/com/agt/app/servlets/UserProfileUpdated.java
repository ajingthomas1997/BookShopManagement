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

@WebServlet("/updateProfileEdit")
public class UserProfileUpdated extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String updatedName = request.getParameter("name");
    	
		String updatedDob = request.getParameter("dob");
    	
		String updatedGender = request.getParameter("gender");
    	
		String updatedContactNumber = request.getParameter("contactNumber");

    	HttpSession session = request.getSession();
    	
    	User user = (User) session.getAttribute("user");
    	
    	user.setName(updatedName);
    
    	user.setDob(updatedDob);
    	
    	user.setGender(updatedGender);
    	
    	user.setContactNumber(Long.parseLong(updatedContactNumber));

    	ServiceFactory.getServiceFactory().getUserServiceImplementation().updateUser(user);
    	
    	session.setAttribute("user", ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserByEmail(user.getEmail()));
    	
        request.getRequestDispatcher("userProfile.jsp").forward(request, response);
        
    }
}
