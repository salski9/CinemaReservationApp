<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Films Valables</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('images/cinema.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #ffffff;
            margin: 0;
            padding: 0;
        }

        .overlay {
            background-color: rgba(0, 0, 0, 0.7);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: rgba(0, 0, 0, 0.9);
            padding: 20px 40px;
            color: #ff0000;
        }

        .header .logo img {
            height: 60px;
        }

        .header .home-icon {
            cursor: pointer;
            font-size: 20px;
            color: white;
        }

        h1 {
            color: #ff0000;
        }

        .form-label {
            color: #ffffff;
        }

        .form-control {
            background-color: transparent;
            color: #fff;
            border: 1px solid rgba(255, 255, 255, 0.4);
        }

        .form-control::placeholder {
            color: rgba(255, 255, 255, 0.5);
        }

        .form-control:focus {
            background-color: transparent;
            color: white;
            border-color: white;
            box-shadow: none;
        }

        .btn-primary {
            background-color: #ff0000;
            border-color: #ff0000;
        }

        .btn-primary:hover {
            background-color: #cc0000;
        }

        .btn-secondary {
            background-color: #555;
            border-color: #444;
            color: white;
        }

        .btn-secondary:hover {
            background-color: #777;
        }

        .form-container {
            background-color: rgba(0, 0, 0, 0.5);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(255, 0, 0, 0.3);
        }

        .footer {
            background-color: rgba(0, 0, 0, 0.8);
            color: white;
            text-align: center;
            padding: 10px;
            margin-top: auto;
        }
    </style>
</head>
<body>
<div class="overlay">
    <!-- Header -->
    <div class="header">
        <div class="logo">
            <img src="images/logoCinema.png" alt="Logo Cinema">
        </div>
        <div class="home-icon" onclick="window.location.href='home.jsp';">
            HOME
        </div>
    </div>

    <!-- Form Section -->
    <h1 class="text-center mt-5">Add a Movie</h1>
	<div class="container mt-4">
	    <form method="POST" action="controleur" enctype="multipart/form-data" class="form-container">
	        <div class="row">
	            <div class="col-md-6">
	                <div class="mb-3">
	                    <label for="nomFilm" class="form-label">Movie Title</label>
	                    <input type="text" id="nomFilm" name="nom" class="form-control" required />
	                </div>
	                <div class="mb-3">
	                    <label for="realisateurFilm" class="form-label">Director</label>
	                    <input type="text" id="realisateurFilm" name="realisateur" class="form-control" required />
	                </div>
	                <div class="mb-3">
	                    <label for="dateProj" class="form-label">Screening Date</label>
	                    <input type="date" id="dateProj" name="dateProj" class="form-control" required />
	                </div>
	                <div class="mb-3">
	                    <label for="filmImage" class="form-label">Movie Poster</label>
	                    <input type="file" id="filmImage" name="filmImage" accept="image/*" class="form-control" required />
	                </div>
	                <div class="text-center">
	                    <button type="submit" value="ajouter" name="action" class="btn btn-primary">Add Movie</button>
	                    <button type="reset" value="Reset" name="reset" class="btn btn-secondary">Reset</button>
	                </div>
	            </div>
	            <div class="col-md-6 d-flex align-items-center justify-content-center">
	                <figure class="text-center">
	                    <img src="images/addFilm.jpg" alt="Add Movie Illustration" class="img-fluid rounded" style="max-width: 100%; height: auto; max-height: 300px;">
	                </figure>
	            </div>
	        </div>
	    </form>
	</div>

    <!-- Footer -->
    <div class="footer">
        <p>&copy; 2025 Cinema Reservation. Tous droits réservés.</p>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
