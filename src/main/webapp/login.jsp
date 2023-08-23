<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style type="text/css">

.gradient-custom {
/* fallback for old browsers */
background-image: url("https://www.webage.co.uk/wp-content/uploads/2017/11/opencart-3-ecommerce-store-admin.jpg");
background-size: 100%;
}

    /* Target the parent <div> containing the social media login section and "Sign Up" link */
    .login-section {
      margin-top: 50px; /* Adjust the value to reduce the gap between the divs */
    }
    
    .card-body {
    	height: 700px;
    }
    
</style>
</head>
<body>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">


		<form action="login" method="post">
            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
              <p class="text-white-50 mb-5">Please enter your username and password</p>

              <div class="form-outline form-white mb-4">
                <input type="email" name="email" id="typeEmailX" class="form-control form-control-lg" placeholder="Email" required/>
                
              </div>
              
              <div class="form-outline form-white mb-4">
    			<input type="password" name="password" id="typePasswordX" class="form-control form-control-lg" placeholder="Password" required/>
			</div>

			<div id="message" style="padding-bottom: 10px">
				<%
				if (request.getAttribute("message") != null) {
				%>
				<span style="color: <%=request.getAttribute("color") %>; padding-left: 4%; padding-bottom: 4%"
					class="error"><b><%=request.getAttribute("message")%></b></span>
				<%
				}
				%>

			</div>

              <p class="text-white-50 fw-bold mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>

              <button class="btn btn-outline-light btn-lg px-5" name="login" type="submit">Login</button>
</form>
              <div class="d-flex justify-content-center text-center mt-4 pt-1">
                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
              </div>

            

            <div class="login-section">
              <p class="mb-0">Don't have an account? <a href="registration.jsp" class="text-white-50 fw-bold">Sign Up</a>
              </p>
            </div>
			</div>
          </div>
        </div>
      </div>
    </div>
  
</section>

</body>
</html>