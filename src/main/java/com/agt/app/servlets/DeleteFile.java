package com.agt.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agt.app.pojos.User;
import com.agt.app.pojos.UserFiles;
import com.agt.app.service.implementations.ServiceFactory;

import java.io.File;

@WebServlet("/deleteFile")
public class DeleteFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Extract the filename and file ID from the request parameters
		int fileId = Integer.parseInt(request.getParameter("id"));

		UserFiles userFiles = ServiceFactory.getServiceFactory().getUserServiceImplementation()
				.getAllUserFilesByFileId(fileId);

		// Delete the file from the project
		String filePath = userFiles.getFilePath();

		File file = new File(filePath);

		if (file.delete()) {

			ServiceFactory.getServiceFactory().getUserServiceImplementation().deleteUserFile(fileId);

			request.setAttribute("ok", "dashboard.jsp");

			request.setAttribute("message", "File deleted successfully!");

			request.getRequestDispatcher("popupBox.jsp").forward(request, response);
		} 
		
		else {
			request.setAttribute("ok", "dashboard.jsp");

			request.setAttribute("message", "Failed to delete file.");

			request.getRequestDispatcher("popupBox.jsp").forward(request, response);
		}
	}
}
