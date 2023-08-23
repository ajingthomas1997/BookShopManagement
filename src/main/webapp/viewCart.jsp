<%@page import="java.util.List"%>
<%@page import="com.agt.app.pojos.User"%>
<%@page import="com.agt.app.pojos.Cart"%>
<%@page import="com.agt.app.service.implementations.ServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (request.getParameter("userId") != null) {
	int id = Integer.parseInt((String) request.getParameter("userId"));
	User user = ServiceFactory.getServiceFactory().getUserServiceImplementation().getUserOrAdminById(id);
	session.setAttribute("user", user);
}
%>
<%
User user = (User) session.getAttribute("user");
System.out.println(user);
List<Cart> cartItems = ServiceFactory.getServiceFactory().getOrderServiceImplementation().getCartItems(user.getId());
double totalAmount = cartItems.stream().mapToDouble(item -> item.getPrice()).sum();
int countOfCartItem = cartItems.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Cart</title>
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
		style="border: 1px solid grey; background-color: black; width: 99%; margin-top: .5%; margin-left: 0;">
		<h1 style='margin-top: 50px; text-align: center; color: white;'>Cart</h1>

		<table style="width: 90%; border: 4px solid white;">
			<tr style='text-align: center;'>
				<th>Book Title</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Edit/Delete</th>
				<th></th>
			</tr>
			<%-- Place your cart items here, example data shown below: --%>
			<%
			if (!cartItems.isEmpty()) {
				for (Cart item : cartItems) {
			%>
			<tr>
				<td><%=ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(item.getBookId()).getTitle()%></td>
				<%
				if (ServiceFactory.getServiceFactory().getBookServiceImplementation().getBookById(item.getBookId())
						.getQuantity() >= item.getQuantity()) {
				%>
				<td><%=item.getQuantity()%></td>
				<td><%=item.getPrice()%></td>
				<%
				} else {
				%>
				<td rowspan="2"><b><a
						style="color: green; font-style: italic;"> Out Of Stock !! </a></b></td>
				<%
				}
				%>
				<td style="display: flex; position: relative; left: 25%;">
					<form action="editCartItem" method="get">
						<button type="submit" name="cartId" value="<%=item.getCartId()%>"
							class="update-btn">
							<i class="fa-solid fa-pen-to-square"></i>
						</button>
					</form>

					<form action="deleteCartItem" method="get">
						<button type="submit" name="cartId" value="<%=item.getCartId()%>"
							class="delete-btn">
							<i class="fa-solid fa-trash"></i>
						</button>
					</form>
				</td>
				<td>
					<form action="buyNow.jsp" method="get">
						<%
						if (countOfCartItem == 1) {
						%>
						<button style="display: none;" type="submit" name="cartId"
							value="<%=item.getCartId()%>" class="cracker-btn">Buy
							Now</button>
						<%
						} else {
						%>
						<button type="submit" name="cartId" value="<%=item.getCartId()%>"
							class="cracker-btn">Buy Now</button>
						<%
						}
						%>

					</form>
				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="4"><h3>Your cart is Empty, Order your
						favorite book now..!!</h3></td>

			</tr>
			<%
			}
			%>

		</table>
		<div
			style="display: flex; justify-content: space-between; align-items: center; margin: 20px 10px;">
			<!-- First Section: Total Amount and Amount -->
			<div
				style="color: white; padding: 10px; border-radius: 5px; display: flex; align-items: center;">
				<h3 style="margin: 0;">
					<b>Total Amount: <%=totalAmount%></b>
				</h3>
			</div>
			<!-- Second Section: Buttons for Place Order and Cancel Order -->
			<div style="display: flex;">
				<form action="placeOrder" method="get">
					<%
					if (totalAmount == 0.0) {
					%>
					<button type="submit" name="userId" value="<%=user.getId()%>"
						style="display: none;">Place Order</button>
					<%
					} else {
					%>
					<!-- The button will be displayed if the total price is not 0.0 -->
					<button type="submit" name="userId" value="<%=user.getId()%>"
						style="background-color: #1ABC9C; color: white; padding: 10px; border-radius: 5px; margin-right: 10px;">Place
						Order</button>
					<%
					}
					%>
				</form>
				<form action="cancelOrder" method="get">
					<%
					if (totalAmount == 0.0) {
					%>
					<button type="submit" name="userId" value="<%=user.getId()%>"
						style="display: none;">Cancel Order</button>
					<%
					} else {
					%>
					<button type="submit" name="userId" value="<%=user.getId()%>"
						style="background-color: #E74C3C; color: white; padding: 10px; border-radius: 5px;">Cancel
						Order</button>
					<%
					}
					%>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
