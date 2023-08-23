<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password - Verification</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body style="background-image: url('https://4kwallpapers.com/images/walls/thumbs_3t/8324.png'); background-size: 100%">

<div class="container mt-5" style="width: 70%;">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header" style="background-color: #c0bfd9">
                    <h3 class="text-center">Account Verification</h3>
                </div>
                <div class="card-body" >
                    <form action="handle_verification.jsp" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label" style="font-size: 20px;"><b>Name</b></label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="mb-3">
                            <label for="dob" class="form-label" style="font-size: 20px;"><b>Date of Birth</b></label>
                            <input type="date" class="form-control" id="dob" name="dob" required>
                        </div>
                        <center><button type="submit" class="btn btn-primary">Submit</button></center>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
