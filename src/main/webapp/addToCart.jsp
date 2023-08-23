<%@page import="com.agt.app.pojos.Book"%>
<%@page import="com.agt.app.service.implementations.ServiceFactory"%>
<%@page import="com.agt.app.pojos.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% User user = (User)session.getAttribute("user"); %>
	<% Book book = (Book)request.getAttribute("book");%>
	<% String path = (String) request.getAttribute("path");%>
	<% String header = (String) request.getAttribute("header"); %>
	<% String button = (String) request.getAttribute("button"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=header %></title>
    <link href="//cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

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
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4" style="color:white;"><%=header %></p>

        <form class="addForm" action="addToCart" method="get" onsubmit="return addToCart()">
            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-book fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <input type="text" id="form3Example1c" class="form-control" name="title" placeholder="Book Title" value="<%=book.getTitle()%>" readonly />
                </div>
            </div>
            
            <input type="hidden" id="form3Example1c" class="form-control" name="bookId" value="<%=book.getId()%>" readonly />
            <input type="hidden" id="form3Example1c" class="form-control" name="userId" value="<%=user.getId()%>" readonly />
            <input type="hidden" id="form3Example1c" class="form-control" name="price" value="<%=book.getPrice()%>" readonly />
            <input type="hidden" id="form3Example1c" class="form-control" name="path" value="<%=path%>" readonly />

            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fa-sharp fas fa-pen-nib fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <input type="text" id="form3Example1c" class="form-control" name="author" placeholder="Name of Author" value="<%=book.getAuthor()%>" readonly />
                </div>
            </div>

            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-tags fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <input type="text" id="form3Example1c" class="form-control" name="category" placeholder="Category" value="<%=book.getCategory()%>" readonly />
                </div>
            </div>

            <div class="d-flex flex-row align-items-center mb-4">
                <i class="fas fa-list fa-lg me-3 fa-fw"></i>
                <div class="form-outline flex-fill mb-0">
                    <input type="number" min="1" max="<%=book.getQuantity()%>" id="quantityInput" class="form-control" name="quantity" placeholder="Quantity" required />
                </div>
            </div>

            <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                <button type="submit" class="btn btn-primary btn-lg" name="button"><%=button %></button>
            </div>

            <div id="message" align="center" style="padding-bottom: 10px">
                <% if (request.getAttribute("message") != null) { %>
                <p style="color: <%=request.getAttribute("color")%>;">
                    <b><%=request.getAttribute("message")%></b>
                </p>
                <% } %>
            </div>
        </form>
    </div>

    <script>
        function addToCart() {
            const quantityInput = document.getElementById("quantityInput");
            const quantity = quantityInput.value;

            // Validate quantity (you can add more validation logic if needed)
            if (quantity <= 0) {
                alert("Please enter a valid quantity greater than 0.");
                quantityInput.focus();
                return false;
            }

            return true; // Allow form submission
        }
    </script>
</body>
</html>