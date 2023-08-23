<%@page import="com.agt.app.pojos.UserFiles"%>
<%@page import="com.agt.app.pojos.Book"%>
<%@ page import="com.agt.app.service.implementations.ServiceFactory"%>
<%@ page import="java.util.List"%>
<%@ page import="com.agt.app.pojos.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<%
if (request.getParameter("userId") != null) {
	int id = Integer.parseInt((String) request.getParameter("userId"));
	User user = ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserOrAdminById(id);
	session.setAttribute("user", user);
}
%>

<%
int booksPerPage = 8;
%>
<%
int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
%>
<%
User user = (User) session.getAttribute("user");
List<UserFiles> userFiles = ServiceFactory.getServiceFactory().getUserServiceImplementation()
		.getAllUserFilesByUserId(user.getId());
%>
<%
int totalBooks = (ServiceFactory.getServiceFactory().getUserServiceImplementation()
		.getAllUserFilesByUserId(user.getId()) == null) ? 0
		: ServiceFactory.getServiceFactory().getUserServiceImplementation()
				.getAllUserFilesByUserId(user.getId()).size();
%>
<%
int totalPages = (int) Math.ceil((double) totalBooks / booksPerPage);
%>
<%
int startIndex = (currentPage - 1) * booksPerPage;
%>
<%
int endIndex = Math.min(startIndex + booksPerPage, totalBooks);
%>

<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet">
<!-- Custom CSS for dark theme -->
<style>
body {
	background-color: #c9d6c9;
	color: #fff;
}

.container {
	background-color: #222;
	border-radius: 10px;
	padding: 20px;
}

h1, h3 {
	color: #fff;
}

.grid-container {
	display: grid;
	grid-template-columns: 1fr 2fr 3fr 2fr 1fr;
	grid-gap: 10px;
	background-color: #000; /* Black background for the table-like grid */
	padding: 10px;
}

.grid-item {
	padding: 5px;
	color: #fff;
	text-align: center;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
}

.btn-primary:hover {
	background-color: #0056b3;
	border-color: #0056b3;
}

.form-control {
	background-color: #333;
	color: #fff;
	border-color: #555;
}

.form-control:focus {
	background-color: #444;
	color: #fff;
	border-color: #555;
	box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, .25);
}
/* Pagination styles */
.pagination {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

.pagination a, .pagination span {
	padding: 10px 15px;
	margin: 0 5px;
	border: 2px solid #007bff; /* Change border thickness to 2px */
	text-decoration: none;
	color: #007bff; /* Use primary color for links */
	background-color: #fff; /* Use white background color */
	border-radius: 5px; /* Slightly rounded edges */
	transition: background-color 0.3s, color 0.3s, border-color 0.3s;
	/* Include transition for smoother effects */
}

.pagination .active {
	background-color: #007bff;
	color: #fff;
}

.pagination a:hover {
	background-color: #7a7a7a; /* Use a subtle background color on hover */
}

.pagination .dots {
	pointer-events: none; /* Disable interaction for the ellipsis */
}

/* Optional: Disabled style for inactive links */
.pagination .disabled {
	opacity: 0.6;
	pointer-events: none;
	cursor: default;
}

.grid-container {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.headers {
	display: flex;
	justify-content: space-between;
	width: 100%;
	padding: 5px;
}

.datas {
	display: flex;
	justify-content: space-between;
	width: 100%;
	padding: 5px;
}

.form-control::placeholder {
	color: #fff; /* Change to your desired color */
}
</style>
</head>
<body>
	<div class="container mt-4">
		<h1 class="mb-4">Dashboard</h1>
		<hr>

		<h3 class="mt-4">Uploaded Files</h3>
		<!-- Custom grid-based table-like layout -->
		<div style="background-color: black;">
			<table style="width: 100%;">
				<%
				if (userFiles != null) {
				%>
				<tr>
					<th><div class="grid-item heading">
							<b>S. No</b>
						</div></th>
					<th><div class="grid-item heading">
							<b>File Name</b>
						</div></th>
					<th><div class="grid-item heading">
							<b>File Path</b>
						</div></th>
					<th><div class="grid-item heading">
							<b>Date</b>
						</div></th>
					<th><div class="grid-item heading">
							<b>Delete</b>
						</div></th>
					<th><div class="grid-item heading">
							<b>Download</b>
						</div></th>
				</tr>
				<%
				for (int i = startIndex; i < endIndex; i++) {
				%>
				<tr>
					<td><div class="grid-item"><%=i + 1%></div></td>
					<td><div class="grid-item"><%=userFiles.get(i).getFilePath().split("/")[userFiles.get(i).getFilePath().split("/").length - 1]%></div></td>
					<td><div class="grid-item"><%=userFiles.get(i).getFilePath()%></div></td>
					<td><div class="grid-item"><%=userFiles.get(i).getDate()%></div></td>
					<td><div class="grid-item">
							<form action="deleteFile" method="GET">
								<button class="btn btn-primary" type="submit" name="id"
									value="<%=userFiles.get(i).getFileId()%>">
									<i class="fas fa-trash"></i>
								</button>
							</form>
						</div></td>
					<td><div class="grid-item">
							<form action="downloadFile" method="GET">
								<button class="btn btn-primary" type="submit" name="id"
									value="<%=userFiles.get(i).getFileId()%>">
									<i class="fas fa-download"></i>
								</button>
							</form>
						</div></td>
				</tr>

				<%
				}
				%>

				<%
				} else {
				%>
				<tr>
					<td colspan="6">
						<h3>
							No File are added by
							<%=user.getName()%>.
						</h3>
					</td>
				</tr>
				<%
				}
				%>
			</table>
		</div>


		<div class="mt-4">
			<h3>Upload New File</h3>
			<!-- File upload form -->
			<form action="uploadFile" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="fileInput" class="form-label">Choose File:</label> <input
						type="file" class="form-control" id="fileInput" name="fileInput"
						placeholder="Copy URL..">
				</div>
				<button type="submit" class="btn btn-primary">Upload</button>
			</form>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>