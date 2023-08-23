<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- popup.jsp -->
<!DOCTYPE html>
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
        align-items: flex-start; /* Change to 'flex-start' to align the content at the top */
        justify-content: center;
    }

    /* Styles for the popup content */
    .popup-content {
        background-color: #fff;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        margin-top: 20px; /* Add margin-top to create space between the top of the page and the popup */
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
            <% if(request.getAttribute("ok")!=null){ %>
                <button class="ok" onclick="handleOK()">OK</button>
                <% } %>
                <% if(request.getAttribute("cancel")!=null){ %>
                <button class="cancel" onclick="handleCancel()">Cancel</button>
                <% } %>
            </div>
        </div>
    </div>

    <script>
        // Function to handle the "OK" button click
        function handleOK() {

            // Redirect to the desired location after the "OK" button is clicked
            window.location.href = "<%= (String)request.getAttribute("ok") %>";
        }

        // Function to handle the "Cancel" button click
        function handleCancel() {

            // Redirect to the desired location after the "Cancel" button is clicked
            window.location.href = "<%= (String)request.getAttribute("cancel") %>";
        }
    </script>
</body>
</html>
