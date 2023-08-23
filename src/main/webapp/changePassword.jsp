<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body style="background-image: url('https://4kwallpapers.com/images/walls/thumbs_3t/8324.png'); background-size: 100%">

<div class="container mt-5" style="width: 70%;">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header" style="background-color: #c0bfd9">
                    <h3 class="text-center">Change Password</h3>
                </div>
                <div class="card-body">
                    <form action="handle_change_password.jsp" method="post">
                        
                        <div class="mb-3">
                            <label for="newPassword" class="form-label" style="font-size: 20px;"><b>New Password</b></label>
                            <input type="password" class="form-control" id="newPassword" name="newPassword" required>
                        </div>
                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label" style="font-size: 20px;"><b>Confirm Password</b></label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                        </div>
                        <center><button type="submit" class="btn btn-primary">Change Password</button></center>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
