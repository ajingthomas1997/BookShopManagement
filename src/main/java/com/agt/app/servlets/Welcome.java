package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Welcome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response){

		try {

			response.sendRedirect("login.jsp");
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
		
	}

}
