<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
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
label {
	color: white;
	padding-bottom: 5%;
}
.fas {
	color: white;
}

</style>

</head>
<body style="background-color: #c9d6c9">
        <div class="container"> 
        
            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4" style="color:white;">Add Book</p>
          

			<form class="addForm" action="addBook" method="Post">
              
            
            <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-book fa-lg me-3 fa-fw"></i> 
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control" name="title" placeholder="Book Title" required="required"/>
                     
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                  	<i class="fa-sharp fas fa-pen-nib fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control" name="author" placeholder="Name of Author" required="required"/>
                     
                    </div>
                  </div>
                  
              <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-tags fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <input type="text" id="form3Example1c" class="form-control" name="category" placeholder="Category" required="required"/>
                </div>
            </div>    
            
            <div class="d-flex flex-row align-items-center mb-4">
            		<i class="fas fa-list fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="number" id="form3Example3c" class="form-control" name="quantity" placeholder="Quantity" required="required"/>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                  	<i class="fa-sharp fas fa-tag fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example4c" class="form-control" name="price" placeholder="Price" required="required"/>
                    </div>
                  </div>

                 <div class="d-flex flex-row align-items-center mb-4">
                  	<i class="fas fa-link fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="url" id="form3Example4c" class="form-control" name="image" placeholder="Image Url" required="required"/>
                    </div>
                  </div>

                 

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-lg">Add</button>
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
</body>
</html>