package com.agt.app.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.agt.app.pojos.User;
import com.agt.app.pojos.UserFiles;
import com.agt.app.service.implementations.ServiceFactory;

//... (other imports)

@WebServlet("/uploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
     maxFileSize = 1024 * 1024 * 10, // 10MB
     maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UploadFile extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

     User user = (User) request.getSession().getAttribute("user");

     // Get the Part representing the uploaded file
     Part filePart = request.getPart("fileInput");

     // Get the filename
     String fileName = getSubmittedFileName(filePart);

     // Define the file destination path
     String fileDestinationPath = "/home/oip10/eclipse-workspace/BookManagementSystem/src/main/webapp/assets/files/"
             + user.getId() + File.separatorChar;

     // Create the destination directory if it doesn't exist
     File destinationDir = new File(fileDestinationPath);
     if (!destinationDir.exists()) {
         destinationDir.mkdirs();
     }

     File uploadedFile = new File(destinationDir, fileName);
     try (InputStream inputStream = filePart.getInputStream()) {
         Files.copy(inputStream, uploadedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
     }

     // Save the file URL in the database

     saveFileURLToDatabase(user, fileDestinationPath+fileName, request, response);
 }

    // Utility method to extract the submitted filename from a Part
    private String getSubmittedFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "unknown";
    }

	private void saveFileURLToDatabase(User user, String fileName, HttpServletRequest request,
			HttpServletResponse response) {

		LocalDate currentDate = LocalDate.now();

		// Define the date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		// Format the current date using the defined format
		String formattedDate = currentDate.format(formatter);
		try {
			if (ServiceFactory.getServiceFactory().getUserServiceImplementation()
					.getUserFileByUserIdAndFilePath(user.getId(), fileName) != null) {

				ServiceFactory.getServiceFactory().getUserServiceImplementation()
						.updateUserFile(new UserFiles(user.getId(), "File", fileName, formattedDate));

				request.setAttribute("ok", "dashboard.jsp");

				request.setAttribute("message", "File has been updated successfully..");

				request.getRequestDispatcher("popupBox.jsp").forward(request, response);

			} else {

				ServiceFactory.getServiceFactory().getUserServiceImplementation()
						.insertUserFile(new UserFiles(user.getId(), "File", fileName, formattedDate));

				request.setAttribute("ok", "dashboard.jsp");

				request.setAttribute("message", "File added successfully..");

				request.getRequestDispatcher("popupBox.jsp").forward(request, response);

			}
		} catch (ServletException | IOException e) {

			e.printStackTrace();

		}
	}
}
