<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Réservation de Film</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        html, body {
            height: 100%;
            margin: 0;
        }

        body {
            background: url('images/cinema.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #ffffff;
        }

        .overlay {
            background-color: rgba(0, 0, 0, 0.85);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: rgba(0, 0, 0, 0.9);
            padding: 15px 40px;
            color: #ff0000;
        }

        .header .logo img {
            height: 60px;
        }

        .header .home-icon {
            font-size: 20px;
            color: white;
            cursor: pointer;
        }

        h2,h3 {
            color: #ff0000;
        }
        h4{
        	#ffffff;
        	text-align: center;
        }

        .details-section {
		    /* old: very transparent */
		    /* background-color: rgba(255, 255, 255, 0.05); */
		    
		    /* new: darker, more opaque overlay */
		    background-color: rgba(0, 0, 0, 0.8);
		    display: flex;
		    align-items: center;
		    margin: 30px auto;
		    padding: 25px;
		    max-width: 1100px;
		    border-radius: 12px;
		    box-shadow: 0 0 12px rgba(255, 0, 0, 0.3);
		}

        .details-section img {
		    width: 40%;
		    max-height: 300px;
		    object-fit: cover;
		    border-radius: 10px;
		}


        .details {
            margin-left: 30px;
            width: 60%;
        }

        .details p {
            color: #ddd;
            margin-bottom: 8px;
        }

        .salles-section {
            padding: 30px;
            max-width: 1100px;
            margin: auto;
        }

        .salles-section .card {
            margin-bottom: 15px;
            background-color: rgba(255, 255, 255, 0.05);
            border: none;
            border-left: 5px solid #ff0000;
            color: #ffffff;
        }

        .card-body {
            padding: 20px;
        }

        .footer {
            background-color: rgba(0, 0, 0, 0.9);
            color: white;
            text-align: center;
            padding: 10px;
            margin-top: auto;
        }

        @media (max-width: 768px) {
		    .details-section {
		        flex-direction: column;
		        text-align: center;
		    }
		
		    .details-section img {
		        width: auto;
		        height: 300px;
		        max-width: 90%;
		        object-fit: contain; /* ensures the whole image shows, no cropping */
		        margin-bottom: 20px;
		        border-radius: 10px;
		    }
		
		    .details {
		        margin-left: 0;
		        width: 100%;
		    }
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
        <div class="home-icon" onclick="window.location.href='home.jsp';">HOME</div>
    </div>

    <!-- Section des films -->
    <div class="movies-section">
        <h2 class="text-center mt-4">Réserver une séance</h2>
        <div class="movies-carousel">
            <c:forEach var="c" items="${liste}">
                <div class="details-section">
                    <img src="${c.urlPhoto != null ? c.urlPhoto : 'images/film_detail.jpg'}" alt="Affiche du film">
                    <div class="details">
                        <h3>Détails du Film</h3>
                        <p>🎬 Nom : <c:out value="${c.nom}"/></p>
                        <p>📅 Date de projection : <c:out value="${c.dateProj}"/></p>
                        <p>🎥 Réalisateur : <c:out value="${c.realisateur}"/></p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Section des salles -->
    <div class="salles-section">
        <h2 class="text-center text-danger">Ce film est projeté dans les salles suivantes :</h2>
        <h4> Aucune salle de projection pour l'instant</h4>
        <div class="row">
            <c:forEach var="c" items="${TousLesSalleDeProg}">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Salle n° <c:out value="${c.id_salleProg}"/></h5>
                        <p class="card-text">Capacité : <c:out value="${c.salleProgCapacite}"/> places</p>
                       
                    </div>
                </div>
            </c:forEach>
        </div>
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
