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

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/registration")
public class RegistrationFilter implements Filter {

	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
	private static final Pattern PASSWORD_PATTERN = Pattern
			.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization code, if needed.
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		long contactNumber = Long.parseLong((String) request.getParameter("contactNumber"));
		
		try {

			// Validate email format
			if (!isValidEmail(email)) {
				request.setAttribute("message", "Invalid email format.");
				request.setAttribute("color", "red");
				
				request.setAttribute("name", name);
				request.setAttribute("dob", dob);
				request.setAttribute("contactNumber", contactNumber);

				request.getRequestDispatcher("/registration.jsp").forward(request, response);

				return;
			}

			// Validate password format and match with repeatPassword
			if (!isValidPassword(password)) {
				request.setAttribute("message", "Invalid password format");
				request.setAttribute("color", "red");
				
				request.setAttribute("name", name);
				request.setAttribute("dob", dob);
				request.setAttribute("contactNumber", contactNumber);
				request.setAttribute("email", email);

				request.getRequestDispatcher("/registration.jsp").forward(request, response);
				return;
			}

			if (!isPasswordMatch(password, repeatPassword)) {
				request.setAttribute("message", "Passwords do not match.");
				request.setAttribute("color", "red");
				
				request.setAttribute("name", name);
				request.setAttribute("dob", dob);
				request.setAttribute("contactNumber", contactNumber);
				request.setAttribute("email", email);

				request.getRequestDispatcher("registration.jsp").forward(request, response);
				return;
			}

			// If all validations pass, proceed with the filter chain.
			chain.doFilter(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}
	}

	@Override
	public void destroy() {
		// Cleanup code, if needed.
	}

	private boolean isValidEmail(String email) {
		return email != null && EMAIL_PATTERN.matcher(email).matches();
	}

	private boolean isValidPassword(String password) {
		return password != null && PASSWORD_PATTERN.matcher(password).matches();
	}

	private boolean isPasswordMatch(String password, String repeatPassword) {
		return password != null && password.equals(repeatPassword);
	}
}
