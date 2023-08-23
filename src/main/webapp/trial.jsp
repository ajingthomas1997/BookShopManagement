<%@page import="com.agt.app.service.implementations.ServiceFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.agt.app.pojos.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

int limit=5,offset=1;
if(request.getParameter("offset")!=null){
	offset = Integer.parseInt((String) request.getParameter("offset"));
}
request.removeAttribute("offset");

List<Book> books = ServiceFactory.getServiceFactory().getBookServiceImplementation().getBooksUsingLimit(
		limit,offset);
int numberOfpages = ServiceFactory.getServiceFactory().getBookServiceImplementation().getAllBooks().size()/limit;
if(ServiceFactory.getServiceFactory().getBookServiceImplementation().getAllBooks().size()%limit>0){
	numberOfpages++;
}
%>
<c:set var="books" value="<%=books%>"></c:set>
<c:set var="numberOfPages" value="<%= numberOfpages%>"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book List with Pagination</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col">
				<h1>Book List</h1>
				<ul class="list-group">
					<%-- Iterate through the books and display them --%>
					<c:forEach var="book" items="${books}">
						<li class="list-group-item">${book.title}-${book.author}</li>
					</c:forEach>
				</ul>
				<nav aria-label="Book Pagination">
					<ul class="pagination">
						<%-- Use c:forEach to generate the pagination links --%>
						<c:forEach var="pageNumber" begin="1" end="${numberOfPages}">
							<li class="page-item"><a class="page-link" href="trial.jsp?offset=${pageNumber}"><c:out
										value="${pageNumber}" /></a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>  
								   
						</a></li>
					</ul>
				</nav>



			</div>
		</div>
	</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- popup.jsp -->
<html>
<head>
    <title>Customized Popup Box</title>
    <style>
        /* Styles for the popup overlay */
        .popup-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.6);
            display: flex;
            align-items: center;
            justify-content: center;
        }

        /* Styles for the popup content */
        .popup-content {
            background-color: #fff;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        }

        /* Styles for the buttons */
        .popup-buttons {
            display: flex;
            justify-content: flex-end;
            margin-top: 20px;
        }

        .popup-buttons button {
            margin-left: 10px;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
        }

        .popup-buttons button.ok {
            background-color: #4caf50;
            color: #fff;
        }

        .popup-buttons button.cancel {
            background-color: #f44336;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="popup-overlay">
        <div class="popup-content">
            <!-- Replace 'message' with the actual message sent from the servlet -->
            <p><%= request.getAttribute("message") %></p>
            <div class="popup-buttons">
                <button class="ok" onclick="handleOK()">OK</button>
                <button class="cancel" onclick="handleCancel()">Cancel</button>
            </div>
        </div>
    </div>

    <script>
        // Function to handle the "OK" button click
        function handleOK() {

            // Redirect to the desired location after the "OK" button is clicked
            window.location.href = "<%= %>";
        }

        // Function to handle the "Cancel" button click
        function handleCancel() {

            // Redirect to the desired location after the "Cancel" button is clicked
            window.location.href = "<%= %>";
        }
    </script>
</body>
</html>
