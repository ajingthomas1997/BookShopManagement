<%@page import="com.agt.app.service.implementations.ServiceFactory"%>
<%@page import="com.agt.app.pojos.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Profile</title>
<script>
	function makeEditable(fieldName) {
		const spanElement = document.getElementById(fieldName + 'Span');
		const inputElement = document.getElementById(fieldName + 'Input');

		// Hide the span and show the input
		spanElement.style.display = 'none';
		inputElement.style.display = 'inline-block';
		inputElement.focus(); // Set the focus on the input element
	}

	document.addEventListener('keyup', function(event) {
		if (event.key === 'Enter') {
			// Save the changes and display the updated value as plain text
			const activeInput = document
					.querySelector('input[type="text"]:focus');
			if (activeInput) {
				const fieldName = activeInput.id.replace('Input', 'Span');
				const spanElement = document.getElementById(fieldName);
				const inputElement = document.getElementById(activeInput.id);

				const newValue = inputElement.value;
				// You may want to save the updated value using AJAX or any other method appropriate for your application

				// Update the plain text display and hide the input element
				spanElement.textContent = newValue;
				inputElement.style.display = 'none';
				spanElement.style.display = 'inline';
			}
		}
	});
	function updateUserData() {
		// Get the updated values from the input elements
		const updatedName = document.getElementById('nameInput').value;
		const updatedDob = document.getElementById('dobInput').value;
		const updatedGender = document.getElementById('genderInput').value;
		const updatedContactNumber = document
				.getElementById('contactNumberInput').value;

		// Set the updated values to the hidden form fields
		document.getElementById('updatedName').value = updatedName;
		document.getElementById('updatedDob').value = updatedDob;
		document.getElementById('updatedGender').value = updatedGender;
		document.getElementById('updatedContactNumber').value = updatedContactNumber;

		// Submit the form to the server
		document.getElementById('updateProfile').submit();
	}
</script>
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
.card-body-header {
	padding-bottom: 5%;
}

h3 {
	text-align: center;
	padding-right: 15%;
	color: white;
	padding-top: 5%;
}

.container {
	width: 60%;
	margin-top: 5%;
	
}

.close-btn {
	position: relative;
	left: 100px;
	bottom: 50px;
}

.userProfilePicture {
	right: 80px;
}

.user-icon img {
	background-color: #ffffff;
	color: black;
	border-radius: 50%;
	padding: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
	position: relative;
	right: 140px;
	font-size: 40px;
}

.img-icon a {
	background-color: #ffffff;
	color: black;
	background: transparent;
	padding-left: 6%;
	position: relative;
	right: 80px;
	top: 10px;
}
.image-container {
    cursor: pointer;
    position: relative; /* Set the position to relative */
    display: inline-block; /* Ensure that the container takes only the necessary space */
}

.image-container img {
    display: block; /* Ensure the image behaves as a block element */
    border-radius: 50%;
    position: relative;
    right: 100%;
}

#overlay {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.8);
    justify-content: center;
    align-items: center;
    z-index: 9999;
}

#fullscreenImage {
    max-width: 90%;
    max-height: 90%;
    border: 2px solid #fff;
    display: block;
    margin: auto;
}

#fullscreenImage:hover {
    cursor: pointer;
}
</style>
</head>
<body
	style="background-image: url('https://4kwallpapers.com/images/walls/thumbs_3t/8324.png'); background-size: 100%">

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-body" style="background-color: #c9d6c9">
						<div class="card-body-header"
							style="display: flex; justify-content: center; align-items: center;">

							<div class="userProfilePicture">
								<div class="image-container">
									<a href="#" onclick="showImage()"> <img
										src="https://yt3.googleusercontent.com/SRcIaFQpx-xYOewEDkRisIQV7l3xBjp2FQeA-FcWYz8MGM2kNcYxp1jKHZyKvIj8ItWK93zzsg=s176-c-k-c0x00ffffff-no-rj"
										alt="Image" width="100" height="100">
									</a>
								</div>

								<div class="overlay" id="overlay" onclick="hideImage()">
									<img
										src="https://yt3.googleusercontent.com/SRcIaFQpx-xYOewEDkRisIQV7l3xBjp2FQeA-FcWYz8MGM2kNcYxp1jKHZyKvIj8ItWK93zzsg=s176-c-k-c0x00ffffff-no-rj"
										alt="Fullscreen Image" id="fullscreenImage">
								</div>


								<div class="img-icon">
									<a href="uploadProfilePicture.jsp" class="uploadImage"><i
										class="fa-sharp fa-solid fa-circle-arrow-up"></i> </a> <a href="deleteProfilePicture"
										class="deleteImage"> <i class="fa-solid fa-trash-can">
									</i>
									</a>

								</div>
							</div>

							<div>
								<h3 class="card-title"
									style="text-align: center; margin-right: 50px;"><b>User
									Profile</b></h3>
							</div>
							<div>
								<form action="userProfileClose" method="post">
									<button class="close-btn" type="submit"
										style="color: black; margin-left: 30%;">
										<i style="right: 0;" class="fa-solid fa-xmark"></i>
									</button>
								</form>
							</div>
						</div>
						<table class="table" border="1px solid white">

							<tr>
								<th>Role</th>
								<td><%=user.getRole()%></td>
								<td></td>
							</tr>
							<tr>
								<th>User Id</th>
								<td><%=user.getId()%></td>
								<td></td>
							</tr>
							<tr>
								<th>Name</th>
								<td><span id="nameSpan"><%=user.getName()%></span> <input
									type="text" id="nameInput" value="<%=user.getName()%>"
									style="display: none;"></td>
								<td><i class="fa-regular fa-pen-to-square"
									onclick="makeEditable('name')"></i></td>
							</tr>
							<tr>
								<th>DOB</th>
								<td><span id="dobSpan"><%=user.getDob()%></span> <input
									type="text" id="dobInput" value="<%=user.getDob()%>"
									style="display: none;"></td>
								<td><i class="fa-regular fa-pen-to-square"
									onclick="makeEditable('dob')"></i></td>
							</tr>
							<tr>
								<th>Gender</th>
								<td><span id="genderSpan"><%=user.getGender()%></span> <input
									type="text" id="genderInput" value="<%=user.getGender()%>"
									style="display: none;"></td>
								<td><i class="fa-regular fa-pen-to-square"
									onclick="makeEditable('gender')"></i></td>
							</tr>
							<tr>
								<th>Email</th>
								<td><%=user.getEmail()%></td>
								<td></td>
							</tr>
							<tr>
								<th>Contact Number</th>
								<td><span id="contactNumberSpan"><%=user.getContactNumber()%></span>
									<input type="text" id="contactNumberInput"
									value="<%=user.getContactNumber()%>" style="display: none;">
								</td>
								<td><i class="fa-regular fa-pen-to-square"
									onclick="makeEditable('contactNumber')"></i></td>
							</tr>
							<tr>
								<td colspan="3" style="text-align: center;">
									<button onclick="updateUserData()">Update</button>
								</td>
							</tr>

							<form id="updateProfileEdit" action="updateProfileEdit"
								method="post">
								<input type="hidden" id="updatedName" name="name"> <input
									type="hidden" id="updatedDob" name="dob"> <input
									type="hidden" id="updatedGender" name="gender"> <input
									type="hidden" id="updatedContactNumber" name="contactNumber">
							</form>



						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
    <script>
        function showImage() {
            const overlay = document.getElementById('overlay');
            overlay.style.display = 'flex';
        }

        function hideImage() {
            const overlay = document.getElementById('overlay');
            overlay.style.display = 'none';
        }
    </script>
</body>
</html>