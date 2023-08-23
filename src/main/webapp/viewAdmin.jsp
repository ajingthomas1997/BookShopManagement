<%@page import="com.agt.app.pojos.Book"%>
<%@ page import="com.agt.app.service.implementations.ServiceFactory"%>
<%@ page import="java.util.List"%>
<%@ page import="com.agt.app.pojos.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%int booksPerPage = 3;%>
<%int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;%>
<% List<User> users = ServiceFactory.getServiceFactory().getUserServiceImplementation().getAllAdmins(); %>
<%
int totalusers = ServiceFactory.getServiceFactory().getUserServiceImplementation().getAllAdmins().size();
%>
<%int totalPages = (int) Math.ceil((double) totalusers / booksPerPage);%>
<%int startIndex = (currentPage - 1) * booksPerPage;%>
<%int endIndex = Math.min(startIndex + booksPerPage, totalusers);%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin List</title>
<link
	href="//cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<style type="text/css">
th, td {
	color: white;
	padding: 20px;
}

td {
	text-align: center;
}

table {
	margin-bottom: 40px;
}

button {
	padding: 5px 10px;
	margin: 5px;
	cursor: pointer;
}
/* Pagination styles */
.pagination {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.pagination a,
.pagination span {
  padding: 10px 15px;
  margin: 0 5px;
  border: 2px solid #007bff; /* Change border thickness to 2px */
  text-decoration: none;
  color: #007bff; /* Use primary color for links */
  background-color: #fff; /* Use white background color */
  border-radius: 5px; /* Slightly rounded edges */
  transition: background-color 0.3s, color 0.3s, border-color 0.3s; /* Include transition for smoother effects */
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

</style>
</head>
<body style="background-color: #c9d6c9">

	<div
		style="border: 1px solid grey; background-color: black; width: 90%; margin-top: 3%; margin-left: 3%;">
		<h1 style='margin-top: 50px; text-align: center; color: white;'>Admin
			List</h1>
		<center>
			<table style="width: 90%; border: 4px solid white;">
				<tr style='text-align: center;'>
					<th>Admin Id</th>
					<th>Name</th>
					<th>Dob</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Edit</th>
				</tr>

				 <%
                if(!users.isEmpty()){
				for (int i = startIndex; i < endIndex; i++) {
				%>
				<tr>
					<td><%= users.get(i).getId() %></td>
					<td><%= users.get(i).getName() %></td>
					<td><%= users.get(i).getDob() %></td>
					<td><%= users.get(i).getGender() %></td>
					<td><%= users.get(i).getEmail() %></td>
					<td><%= users.get(i).getContactNumber() %></td>
					<td style="display: flex;">
                            <form action="updateAdmin.jsp" method="get">
                                <button type="submit" class="update-btn" name="id" value="<%= users.get(i).getId() %>"><i class="fa-solid fa-pen-to-square"></i></button>
                            </form>
                            <form action="deleteAdmin" method="post">
                                <button type="submit" class="delete-btn" name="id" value="<%= users.get(i).getId() %>"><i class="fa-solid fa-trash"></i></button>
                            </form>
                        </td>
				</tr>
				<%
				}}
				else {
				%>
				<tr>
					<td colspan="4"><h3>No Admins are Added</h3></td>
				</tr>
				<%} %>

			</table>
			 <%
                if(!users.isEmpty()){
				%>
			<%-- Pagination links --%>
			<div class="pagination">
				<% if (currentPage > 1) { %>
				<a href="?page=<%= currentPage - 1 %>">Previous</a>
				<% } %>

				<% for (int i = 1; i <= totalPages; i++) { %>
				<%-- Highlight the current page link --%>
				<% if (i == currentPage) { %>
				<span class="active"><%= i %></span>
				<% } else { %>
				<a href="?page=<%= i %>"><%= i %></a>
				<% } %>
				<% } %>

				<% if (currentPage < totalPages) { %>
				<a href="?page=<%= currentPage + 1 %>">Next</a>
				<% } %>
			</div>
			<%} %>
		</center>
	</div>

</body>
</html>
