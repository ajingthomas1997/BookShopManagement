package com.agt.app.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.agt.app.pojos.User;
import com.agt.app.pojos.UserFiles;
import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/uploadProfilePicture")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadProfilePictureServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		String url = "";

		// save file path in directory..
		saveFileMetadataToDatabase(user, request, url);

		// Redirect or send a response to the user
		request.setAttribute("message", "Profile Picture Uploaded.!!");

		request.setAttribute("ok", "userProfile.jsp");

		try {
			
			request.getRequestDispatcher("popupBox").forward(request, response);
		
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		
		}

	}

	private void saveFileMetadataToDatabase(User user, HttpServletRequest request, String filePath) {

		LocalDate currentDate = LocalDate.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        String date = currentDate.format(dateFormatter);
		
		if (ServiceFactory.getServiceFactory().getUserServiceImplementation().getProfilePicture(user.getId())!=null) {

			ServiceFactory.getServiceFactory().getUserServiceImplementation().insertProfilePicture(new UserFiles(user.getId(), "ProfilePicture", filePath, date));
		}

		else {

			ServiceFactory.getServiceFactory().getUserServiceImplementation().updateProfilePicture(new UserFiles(user.getId(), "ProfilePicture", filePath, date));

		}
	}

}
