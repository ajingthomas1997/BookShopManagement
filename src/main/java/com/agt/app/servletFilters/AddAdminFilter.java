package com.agt.app.servletFilters;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/addAdmin") // Change to the actual URL pattern for your registration servlet
public class AddAdminFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// Get form parameters


		String name = request.getParameter("name");
		
		String dob = request.getParameter("dob");
		
		String gender = request.getParameter("gender");
		
		String contactNumber = request.getParameter("contactNumber");
		
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		
		String repeatPassword = request.getParameter("repeatPassword");

		// Perform validation
		
		boolean isValid = true;
		
		if (name == null || dob == null || gender == null || contactNumber == null || email == null
		
				|| password == null || repeatPassword == null || name.isEmpty() || dob.isEmpty()
				
				|| gender.isEmpty() || contactNumber.isEmpty() || email.isEmpty() || password.isEmpty()
				
				|| repeatPassword.isEmpty()) {
			
			isValid = false;
			
			request.setAttribute("message", "Invalid Input");
			
			request.setAttribute("color", "red");

		} else {
		
			// Validate email using regex
			
			String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
			
			if (!Pattern.matches(emailRegex, email)) {
			
				isValid = false;
				
				request.setAttribute("message", "Invalid email format.");
				
				request.setAttribute("color", "red");
			
			} else {

				// Validate password using regex (e.g., at least one uppercase, one lowercase,
				// one digit, one special character, and minimum length)
				
				String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
				
				if (!Pattern.matches(passwordRegex, password)) {
				
					isValid = false;
					
					request.setAttribute("message", "Invalid password format.");
					
					request.setAttribute("color", "red");
				
				} else {
				
					if (!password.equals(repeatPassword)) {
					
						isValid = false;
						
						request.setAttribute("message", "Passwords do not match.");
						
						request.setAttribute("color", "red");
					}
					else {
						
						chain.doFilter(request, response);
					}

				}
			}

		}

		if (!isValid) {

			request.getRequestDispatcher("addAdmin.jsp").forward(httpRequest, httpResponse);
		}
	}

	@Override
	public void destroy() {

	}
}
