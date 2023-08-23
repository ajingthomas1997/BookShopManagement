<%@page import="com.agt.app.pojos.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% User user = (User)session.getAttribute("user"); 
	request.setAttribute("user", user);
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Super Admin Home Page</title>

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

<!-- Add the following CSS style to your existing stylesheet or create a new CSS file -->

<script>
	function loadPage(pageUrl) {
		var iframeElement = document.getElementById('content');

		if (iframeElement instanceof HTMLIFrameElement) {
			iframeElement.src = pageUrl;
		}
	}
	
</script>


<style>

/* Custom styles for the header */
.main-header {
	background-color: #3498db;
	color: #ffffff;
	padding: 1% 0%;
}

.navbar-brand {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

.project-1 {
	font-size: 100%;
	font-weight: bold;
	margin-left: 50%;
	font-weight: bolder;
}

.name {
	font-size: 100%;
	font-weight: bold;
	margin-bottom: 2%;
	margin-left: 10%;
	font-weight: bolder;
}

.role {
	font-size: 100% margin-left: 10%;
	font-weight: bolder;
}

.form-inline .input-group {
	position: relative;
	left: 0;
	display: flex;
	width: 180%;
}

.user-icon {
	font-size: 200%;
}

.user-icon i {
	background-color: #ffffff;
	color: #3498db;
	border-radius: 50%;
	padding: 15px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
	position: relative;
	right: 100%
}

/* Additional custom styles for the sidebar */
.sidebar {
	height: 150vh;
	background-color: blue;
	
}

.sidebar .navbar-brand {
	color: white;
	font-weight: bold;
	display: flex;
	align-items: center;
	justify-content: center;
	padding-top: 30px;
	padding-bottom: 100px;
}

.sidebar .nav-link {
	color: white;
	font-weight: normal;
	padding-left: 20px;
}

.sidebar .nav-link:hover, .sidebar .nav-link:focus {
	text-decoration: none;
}



/* Customize menu appearance */
.sidebar h3 {
	margin-top: 30px;
	margin-bottom: 100;
	/* Remove default margin to prevent extra spacing */
}

.sidebar .btn-link {
	color: white; /* Set menu text color to black */
	font-weight: bold; /* Make menu text bold */
	text-decoration: none; /* Remove the underline from the menu */
	display: block; /* Ensure the entire button area is clickable */
	padding: 50; /* Remove default padding to minimize spacing */
}

.sidebar .btn-link:hover, .sidebar .btn-link:focus {
	text-decoration: none; /* Remove underline on hover/focus */
}

/* Customize submenu appearance */
.sidebar .nav-link {
	color: white; /* Set submenu text color to black */
	font-weight: normal; /* Reset submenu text to normal weight */
	padding-left: 20px; /* Indent the submenu items */
}

.sidebar .nav-link:hover, .sidebar .nav-link:focus {
	text-decoration: none; /* Remove underline on hover/focus */
}

.fixed-bottom {
    position: fixed;
    bottom: 0;
    padding-bottom: 3px;
    margin-top: 400px;
    background-color: blue; /* Change the background color of the logout section */
	width: 16.7%;
}

.btn-logout {
    color: white;
    text-decoration: none;
    padding: 10px;
    border: none;
    background: transparent;
    cursor: pointer;
    font-size: 20px;
    display: block; /* Ensure the entire button area is clickable */
    width: 100%; /* Make the logout button fill the entire width */
    text-align: center; /* Align the text to the left */
}

.btn-logout:hover {
	text-decoration: underline;
}

.footer {
		background-color: #3498db;
		color: #ffffff;
		padding: 10px;
		text-align: center;
		position: fixed;
		bottom: 0;
		left: 0;
		width: 100%;
		height: 7%;
	}

	.footer p {
		margin: 0;
	}
</style>
</head>
<body style="background-color: #c9d6c9">
	<!-- Your existing HTML code remains unchanged -->
	<header class="main-header">
		<div class="container-fluid">
			<nav class="navbar navbar-dark bg-dark">

				<!-- Brand Name and Role -->
				<div class="navbar-brand">
					<div class="project-1">AGT Book Shop</div>
				</div>

				<!-- Search Bar with Icon -->
				<form class="form-inline my-2 my-lg-0 ml-auto">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search">
						<span class="input-group-text"><i class="fas fa-search"></i></span>
					</div>
				</form>

				<!-- Brand Name and Role -->
				<div class="navbar-brand">
					<div class="name"><%= user.getName() %></div>
					<div class="role"><%= user.getRole() %></div>
				</div>

				<!-- User Icon -->
				<div class="user-icon">
					<a href="userProfile.jsp" class="user-btn"
						style="background: transparent;"><i class="fas fa-user"></i></a>
				</div>
			</nav>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<!-- Side Navbar -->
			<nav class="col-md-3 col-lg-2 bg-dark sidebar">
				<div class="position-sticky">
							<!-- Dashboard Button -->
                    <h3>
                        <button class="btn btn-link" type="button" onclick="loadPage('dashboard.jsp?id=<%=user.getId() %>')" style="font-size: 90%;">DASHBOARD</button>
                    </h3>
					<!-- Menu 1 -->
					<h3>
						<button class="btn btn-link collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#menu1"
							aria-expanded="false" aria-controls="menu1">ADMINS</button>
					</h3>
					<div class="collapse show" id="menu1">
						<ul class="nav flex-column">
							<li class="nav-item"><a onclick="loadPage('addAdmin.jsp')"
								class="nav-link" >Add Admin</a></li>
							<li class="nav-item"><a onclick="loadPage('viewAdmin.jsp')"
								class="nav-link" >View Admin</a></li>

						</ul>
					</div>

					<!-- Menu 2 -->
					<h3>
						<button class="btn btn-link collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#menu2"
							aria-expanded="false" aria-controls="menu2">USERS</button>
					</h3>
					<div class="collapse" id="menu2">
						<ul class="nav flex-column">
							<li class="nav-item"><a onclick="loadPage('addUser.jsp')"
								class="nav-link" href="#">Add User</a></li>
							<li class="nav-item"><a onclick="loadPage('viewUser.jsp')"
								class="nav-link" href="#">View User</a></li>

						</ul>
					</div>

					<!-- Menu 3 -->
					<h3>
						<button class="btn btn-link collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#menu3"
							aria-expanded="false" aria-controls="menu3">BOOKS</button>
					</h3>
					<div class="collapse" id="menu3">
						<ul class="nav flex-column">
							<li class="nav-item"><a onclick="loadPage('addBook.jsp')"
								class="nav-link" href="#">Add Book</a></li>
							<li class="nav-item"><a onclick="loadPage('viewBookForAdmin.jsp')"
								class="nav-link" href="#">View Book</a></li>

						</ul>
					</div>

					<!-- Menu 4 -->
					<h3>
						<button class="btn btn-link collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#menu4"
							aria-expanded="false" aria-controls="menu4">ORDERS</button>
					</h3>
					<div class="collapse" id="menu4">
						<ul class="nav flex-column">
							<li class="nav-item"><a onclick="loadPage('viewOrdersForAdmin.jsp')"
								class="nav-link" href="#">View Order</a></li>


						</ul>
					</div>
				</div>
				<div class="fixed-bottom">
					<form action="logout" method="Post">
						<button class="btn btn-link btn-logout" type="submit">Logout</button>
					</form>
				</div>
			</nav>

			<!-- Main Content Area -->
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 ">
				<!-- Your main content will go here -->

				<div style="padding-bottom: 10px; margin: 0; padding-top: 0">
					<iframe id="content" style="height: 150vh; width: 100%;">
					</iframe>
				</div>
				
				<!-- Footer -->
				<div class="footer">
					<p>AGT Book Shop &copy; 2023. All rights reserved.</p>
				</div>
			</main>
		</div>
	</div>



</body>
</html>

