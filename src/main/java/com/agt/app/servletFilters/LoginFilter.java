package com.agt.app.servletFilters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/login")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

		String email = request.getParameter("email");
		
		String password = request.getParameter("password");

		boolean isValidEmail = isValidEmail(email);

		boolean isValidPassword = isValidPassword(password);
		
		try {
		
			if (!isValidEmail || !isValidPassword) {

				request.setAttribute("message", "Invalid email or password. \nRegistration failed.");

				request.setAttribute("color", "red");

				request.getRequestDispatcher("login.jsp").forward(request, response);

				return;
			}

			chain.doFilter(request, response);
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		} catch (ServletException e) {
	
			e.printStackTrace();
		
		}
	
	}

	private boolean isValidEmail(String email) {
		return email != null && !email.isEmpty();
	}

	private boolean isValidPassword(String password) {
		return password != null && password.length() >= 8;
	}

	@Override
	public void destroy() {

	}
}