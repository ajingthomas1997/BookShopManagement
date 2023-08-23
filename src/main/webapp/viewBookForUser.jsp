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
<%int booksPerPage = 8;%>
<%int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;%>
<%List<Book> books = ServiceFactory.getServiceFactory().getBookServiceImplementation().getAllBooks();%>
<%
int totalBooks = ServiceFactory.getServiceFactory().getBookServiceImplementation().getAllBooks().size();
%>
<%int totalPages = (int) Math.ceil((double) totalBooks / booksPerPage);%>
<%int startIndex = (currentPage - 1) * booksPerPage;%>
<%int endIndex = Math.min(startIndex + booksPerPage, totalBooks);%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
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
.item-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
}

.item-box {
	width: 250px;
	height :430px;
	border: 2px solid #ccc;
	border-radius: 8px;
	padding: 10px;
	background-color: #f0f0f0;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
	transition: transform 0.2s ease-in-out;
}

.item-box:hover {
	transform: scale(1.05);
}

.item-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}

.book-id {
	font-size: 16px;
	font-weight: bold;
}

.edit-icon {
	display: flex;
	gap: 2px;
}

.edit-icon button {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 8px 12px;
	border-radius: 4px;
	cursor: pointer;
	font-size: 12px;
	margin-left:30px;
}

.delete-btn button {
	background-color: #f44336;
}

.item-content p {
	margin: 5px 0;
}

.item-content p strong {
	font-weight: bold;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	background-color: #f7f7f7;
}

button {
	padding: 5px 10px;
	margin: 5px;
	cursor: pointer;
}

.item-image {
	text-align: center;
	margin-bottom: 10px;
}

.item-image img {
	width: 120px;
	height: 150px;
	border: 1px solid #ccc;
	border-radius: 8px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
	transition: transform 0.2s ease-in-out;
}

.item-image img:hover {
	transform: scale(1.1);
}

.cart-button {
	display: flex;
	margin-left: 85%;
	position: relative;
	bottom: 50px;
	background-color: #9aaddb; /* Light red for the border color */
	border: 1px solid #f8d7da; /* Light red for the border color */
	border-radius: 8px; /* Border radius to make it look cracker-shaped */
	padding: 10px; /* Add some padding to the button */
	font-size: 18px; /* Font size for the text */
	color: black; /* Dark red for the text color */
	font-weight: bold; /* Bold text for emphasis */
}
/* Pagination styles */
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
</style>
</head>
<body style="background-color: #c9d6c9">

	<div
		style="border: 1px solid grey; background-color: black; width: 99%; margin-left: 0;">
		<h1 style='margin-top: 50px; text-align: center; color: white;'>Book
			List</h1>

		<div class="cart-button-container">
			<form action="viewCart.jsp">
				<button type="submit" class="cart-button">Go to Cart</button>
			</form>
		</div>
		<center>
			<div class="item-container">
				<%
                if(!books.isEmpty()){
				for (int i = startIndex; i < endIndex; i++) {
				%>
				<div class="item-box">
					<div class="item-image">
						<img
							src="<%= books.get(i).getImage() %>"
							alt="Book Cover">
					</div>
					<div class="item-header">

						<span class="edit-icon">
							<form action="getBookDetailsForCart" method="get">
								<button type="submit" class="cart-shopping" name="bookId" value="<%=books.get(i).getId()%>">
									<i class="fa-solid fa-cart-shopping"></i> <b>Add To Cart</b>
								</button>
							</form>
							<form action="buyNow" method="get">
								<button type="submit" class="basket-shopping" name="bookId" value="<%=books.get(i).getId()%>">
									<i class="fa-solid fa-basket-shopping"></i> Buy Now
								</button>
							</form>
						</span>
					</div>
					<div class="item-content">
						<p>
							<strong>Title:</strong>
							<%=books.get(i).getTitle()%></p>
						<p>
							<strong>Author:</strong>
							<%=books.get(i).getAuthor()%></p>
						<p>
							<strong>Category:</strong>
							<%=books.get(i).getCategory()%></p>
						<p>
							<strong>Quantity:</strong>
							<%=books.get(i).getQuantity()%></p>
						<p>
							<strong>Price:</strong>
							<%=books.get(i).getPrice()%></p>
					</div>
				</div>
				<%
				}}
				else {
				%>
				<tr>
					<td colspan="4"><h3>No Books are Added</h3></td>

				</tr>
				<%} %>
			</div>
			<%
                if(!books.isEmpty()){
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
			<% } %>
		</center>
	</div>

</body>
</html>
