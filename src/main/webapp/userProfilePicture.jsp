<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View User Profile Image</title>
<style>
body {
    margin: 0;
    padding: 0;
    background-color: #000;
}

.image-container {
    cursor: pointer;
    position: relative; /* Set the position to relative */
    display: inline-block; /* Ensure that the container takes only the necessary space */
}

.image-container img {
    display: block; /* Ensure the image behaves as a block element */
    max-width: 100%; /* To ensure responsiveness */
    height: auto; /* To maintain aspect ratio */
}

#overlay {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.8);
    justify-content: center;
    align-items: center;
    z-index: 9999;
}

#fullscreenImage {
    max-width: 90%;
    max-height: 90%;
    border: 2px solid #fff;
    display: block;
    margin: auto;
}

#fullscreenImage:hover {
    cursor: pointer;
}
</style>

</head>
<body>
   <div class="image-container">
        <a href="#" onclick="showImage()">
            <img src="https://img.freepik.com/premium-photo/opened-book-with-flying-pages-butterflies-dark-backgroundgenerative-ai_391052-12859.jpg" alt="Image" width="200" height="150">
        </a>
    </div>

    <div class="overlay" id="overlay" onclick="hideImage()">
        <img src="https://img.freepik.com/premium-photo/opened-book-with-flying-pages-butterflies-dark-backgroundgenerative-ai_391052-12859.jpg" alt="Fullscreen Image" id="fullscreenImage">
    </div>

    <script>
        function showImage() {
            const overlay = document.getElementById('overlay');
            overlay.style.display = 'flex';
        }

        function hideImage() {
            const overlay = document.getElementById('overlay');
            overlay.style.display = 'none';
        }
    </script>
</body>
</html>