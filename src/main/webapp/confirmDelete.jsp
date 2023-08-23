<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Delete Confirmation</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    /* Custom styles for the page */
    .container {
        margin-top: 50px;
    }

    .btn-delete {
        background-color: #dc3545;
        color: white;
    }
</style>
</head>
<body style="background-image: url('https://4kwallpapers.com/images/walls/thumbs_3t/8324.png'); background-size: 100%">
s
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Delete Confirmation</h5>
                    <p class="card-text">Are you sure you want to delete the item?</p>
                    <div class="text-center">
                        <a href="#" class="btn btn-delete">Delete</a>
                        <a href="#" class="btn btn-secondary">Cancel</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap 5 JS bundle (Popper.js and Bootstrap.js) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
