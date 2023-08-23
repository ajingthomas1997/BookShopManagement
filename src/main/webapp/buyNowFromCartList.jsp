<%@page import="com.agt.app.pojos.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.agt.app.pojos.User"%>
<%@page import="com.agt.app.pojos.Cart"%>
<%@page import="com.agt.app.service.implementations.ServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cart cart = (Cart) ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItemByCartId(Integer.parseInt(request.getParameter("cartId")));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Now From Cart List</title>
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
body {
	background-color: #c9d6c9;
}

th, td {
	color: white;
	padding: 20px;
	text-align: center;
}

td {
	text-align: center;
}

table {
	margin-bottom: 40px;
	margin-left: 5%;
}

button {
	padding: 5px 10px;
	margin: 5px;
	cursor: pointer;
}

.cracker-btn {
	background-color: #f8d7da; /* Light red for the border color */
	border: 1px solid #f8d7da; /* Light red for the border color */
	border-radius: 8px; /* Border radius to make it look cracker-shaped */
	padding: 10px; /* Add some padding to the button */
	font-size: 15px; /* Font size for the text */
	color: #721c24; /* Dark red for the text color */
	font-weight: bold; /* Bold text for emphasis */
}
</style>
</head>
<body>
	<div
		style="border: 1px solid grey; background-color: black; width: 90%; margin-top: 3%; margin-left: 3%;">
		<h1 style='margin-top: 50px; text-align: center; color: white;'>Buy
			Now</h1>

		<table style="width: 90%; border: 4px solid white;">
			<tr style='text-align: center;'>
				<th>Book Title</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<%-- Place your cart items here, example data shown below: --%>

			<tr>
				<td><%=ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(cart.getBookId()).getTitle()%></td>
				<td><%=cart.getQuantity()%></td>
				<td><%=cart.getPrice()%></td>
			</tr>
		</table>
		<div
			style="display: flex; justify-content: space-between; align-items: center; margin: 20px 10px;">
			<!-- First Section: Total Amount and Amount -->
			<div
				style="color: white; padding: 10px; border-radius: 5px; display: flex; align-items: center;">
				<h3 style="margin: 0;">
					<b>Total Amount: Rs.<%=cart.getQuantity() * cart.getPrice()%>
					</b>
				</h3>
				<%--       <h3 style="margin: 0; margin-left: 10px;"><%= calculateTotalAmount() %></h3> <!-- Replace this with dynamic total amount calculation -->  --%>
			</div>

			<!-- Second Section: Buttons for Place Order and Cancel Order -->
			<div style="display: flex;">
				<form action="placeSingleOrder" method="get">
					<button type="submit" name="cartId" value="<%=cart.getCartId()%>"
						style="background-color: #1ABC9C; color: white; padding: 10px; border-radius: 5px; margin-right: 10px; ">Place
						Order</button>
				</form>
				<form action="cancelSingleOrder" method="get">
					<button type="submit" name="cartId" value="<%=cart.getCartId()%>"
						style="background-color: #E74C3C; color: white; padding: 10px; border-radius: 5px;">Cancel
						Order</button>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
