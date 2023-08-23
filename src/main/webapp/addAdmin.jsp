<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Form</title>
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
.container {
	border: 2px solid white;
	border-radius: 10px;
	width: 50%;
	height: 80%;
	margin-top: 3%;
	margin-bottom: 10%;
	padding-right: 5%;
	padding-left: 5%;
	background-color: black;
}

.form-control {
	margin-right: 50px;
}

label {
	color: white;
	padding-bottom: 5%;
}

.fas {
	color: white;
}
.fa-eye, .fa-eye-slash {
        color: black;
        margin-right: 2%;
    }
</style>

</head>
<body style="background-color: #c9d6c9">
	<div class="container">

		<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4"
			style="color: white;">Admin Form</p>


		<form class="addForm" action="addAdmin" method="post">
			

			<div class="d-flex flex-row align-items-center mb-4">
				<i class="fas fa-user fa-lg me-3 fa-fw"></i>
				<div class="form-outline flex-fill mb-0">
					<input type="text" id="form3Example1c" class="form-control"
						name="name" placeholder="Your name" />

				</div>
			</div>
			
			

			<div class="d-flex flex-row align-items-center mb-4">
				<i class="fas fa-calendar-alt fa-lg me-3 fa-fw"></i>
				<div class="form-outline flex-fill mb-0">
					<input type="date" id="form3Example1c" class="form-control"
						name="dob" placeholder="Date Of Birth" />

				</div>
			</div>

			<div class="form-group">
				<i class="fas fa-venus-mars fa-lg me-3 fa-fw"></i>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="male" value="Male" checked> <label
						class="form-check-label" for="male">Male</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="female" value="Female"> <label
						class="form-check-label" for="female">Female</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="other" value="other"> <label
						class="form-check-label" for="other">Other</label>
				</div>
			</div>
			
			<div class="d-flex flex-row align-items-center mb-4">
				<i class="fas fa-phone fa-lg me-3 fa-fw"></i>
				<div class="form-outline flex-fill mb-0">
					<input type="text" id="form3Example1c" class="form-control"
						name="contactNumber" placeholder="Your contact number" />

				</div>
			</div>
			
			<div class="d-flex flex-row align-items-center mb-4">
				<i class="fas fa-link fa-lg me-3 fa-fw"></i>
				<div class="form-outline flex-fill mb-0">
					<input type="url" id="form3Example1c" class="form-control"
						name="url" placeholder="Copy URL" />

				</div>
			</div>

			<div class="d-flex flex-row align-items-center mb-4">
				<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
				<div class="form-outline flex-fill mb-0">
					<input type="email" id="form3Example3c" class="form-control"
						name="email" placeholder="Email" />
				</div>
			</div>

			<div class="d-flex flex-row align-items-center mb-4">
				<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
				<div class="form-outline flex-fill mb-0 position-relative">
					<input type="password" id="passwordInput" class="form-control"
						name="password" placeholder="Password" /> <i
						class="fas fa-eye-slash position-absolute top-50 end-0 translate-middle-y"
						id="togglePassword" style="cursor: pointer;"></i>
				</div>
			</div>

			<div class="d-flex flex-row align-items-center mb-4">
				<i class="fas fa-key fa-lg me-3 fa-fw"></i>
				<div class="form-outline flex-fill mb-0 position-relative">
					<input type="password" id="repeatPasswordInput"
						class="form-control" name="repeatPassword"
						placeholder="Repeat Password" /> <i
						class="fas fa-eye-slash position-absolute top-50 end-0 translate-middle-y"
						id="toggleRepeatPassword" style="cursor: pointer;"></i>
				</div>
			</div>


			<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
				<button type="submit" class="btn btn-primary btn-lg" >Add</button>
			</div>

			<div id="message" align="center" style="padding-bottom: 10px">
				<%
				if (request.getAttribute("message") != null) {
				%>
				<p style="color: <%=request.getAttribute("color")%>;">
					<b><%=request.getAttribute("message")%></b>
				</p>
				<%
				}
				%>
			</div>

		</form>
	</div>
		<script type="text/javascript">
		function togglePasswordVisibility(inputId, toggleIconId) {
			const passwordInput = document.getElementById(inputId);
			const toggleIcon = document.getElementById(toggleIconId);

			if (passwordInput.type === "password") {
				passwordInput.type = "text";
				toggleIcon.classList.remove("fa-eye-slash");
				toggleIcon.classList.add("fa-eye");
			} else {
				passwordInput.type = "password";
				toggleIcon.classList.remove("fa-eye");
				toggleIcon.classList.add("fa-eye-slash");
			}
		}

		document.getElementById("togglePassword")
				.addEventListener(
						"click",
						function() {
							togglePasswordVisibility("passwordInput",
									"togglePassword");
						});

		document.getElementById("toggleRepeatPassword").addEventListener(
				"click",
				function() {
					togglePasswordVisibility("repeatPasswordInput",
							"toggleRepeatPassword");
				});
	</script>
</body>
</html>