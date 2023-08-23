package com.agt.app.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agt.app.service.implementations.ServiceFactory;

@WebServlet("/downloadFile")
public class DownloadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the file URL from the database based on the record's ID
        int recordId = Integer.parseInt(request.getParameter("id"));
        String fileURL = ServiceFactory.getServiceFactory().getUserServiceImplementation().getAllUserFilesByFileId(recordId).getFilePath();

        System.out.println(fileURL);
        
        if (fileURL != null) {
            // Extract the filename from the URL
            String fileName = fileURL.substring(fileURL.lastIndexOf('/') + 1);

            // Set response content type
            response.setContentType("application/octet-stream");

            // Set the "Content-Disposition" header to indicate the file should be downloaded
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            File file = new File(fileName);
            
            // Create input stream for the file
            FileInputStream fileInputStream = new FileInputStream(file);

            // Get the output stream to write the file content to the response
            OutputStream outputStream = response.getOutputStream();

            try {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } finally {
                fileInputStream.close();
                outputStream.close();
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File URL not found in the database.");
        }
    }
}
