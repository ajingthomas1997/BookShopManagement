<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Your Profile Picture</title>
    <link href="//cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .upload-form {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ced4da;
            border-radius: 5px;
            background-color: #f8f9fa;
        }

        .form-icon {
            font-size: 20px;
        }

        .upload-btn {
            background-color: #34568B;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.2s ease;
        }

        .upload-btn:hover {
            background-color: #1A3867;
        }

        .url-icon {
            background: transparent;
            color: #34568B;
            border-radius: 50%;
            padding: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            
        }

        .url-input-group {
            display: flex;
            align-items: center;
        }
    </style>
</head>

<body style="background-image: url('https://4kwallpapers.com/images/walls/thumbs_3t/8324.png'); background-size: 100%">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="upload-form" style="background-color: #c9d6c9; margin-top: 30%;">
                    <h3 class="text-center mb-4">Upload Your Profile Picture</h3>
                    <form action="" method="post" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="profilePictureUrl" class="form-label">Profile Picture URL</label>
                            <div class="url-input-group">
                                <i class="fas fa-image url-icon fa-lg me-3 fa-fw"></i>
                                <input type="url" class="form-control" id="profilePictureUrl" name="profilePictureUrl"
                                    placeholder="https://example.com/your-profile-picture.jpg" required>
                            </div>
                        </div>

                        <!-- Add more input fields here if needed -->

                        <div class="d-grid gap-2 mt-4">
                            <button type="submit" class="btn btn-primary upload-btn">Upload</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
