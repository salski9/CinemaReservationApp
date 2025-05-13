<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion Utilisateur</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('images/cinema.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #fff;
            margin: 0;
            padding: 0;
        }

        .overlay {
            background-color: rgba(0, 0, 0, 0.8);
            min-height: 100vh;
            padding: 40px 20px;
        }

        .header {
		    display: flex;
		    justify-content: space-between;
		    align-items: center;
		    background-color: rgba(0, 0, 0, 0.7); /* More transparent */
		    padding: 20px 40px;
		    color: #fff;
		    border-bottom: 1px solid rgba(255, 255, 255, 0.1);
		    backdrop-filter: blur(4px);
		    position: sticky;
		    top: 0;
		    z-index: 1000;
		}
		
		.header .logo img {
		    height: 55px;
		    filter: drop-shadow(0 0 5px rgba(255,0,0,0.4));
		}
		
		 .header .home-icon {
            cursor: pointer;
            font-size: 20px;
            color: white;
        }
		
		.header .home-icon:hover {
		    color: #ffffff;
		    text-decoration: underline;
		}
		
		.footer {
		    background-color: rgba(0, 0, 0, 0.7); /* Lighter footer */
		    color: #ccc;
		    text-align: center;
		    padding: 15px 10px;
		    font-size: 0.9rem;
		    border-top: 1px solid rgba(255, 255, 255, 0.1);
		    backdrop-filter: blur(4px);
		    margin-top: 60px;
		}
        

        .card {
            background-color: rgba(0, 0, 0, 0.7);
            color: white;
            border: 1px solid rgba(255, 255, 255, 0.2);
            box-shadow: 0 0 15px rgba(255, 0, 0, 0.3);
        }

        .card-title {
            color: #ff0000;
        }

        .btn-danger {
            background-color: #ff0000;
            border: none;
        }

        .btn-danger:hover {
            background-color: #cc0000;
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

        <!-- Main Content -->
        <div class="container mt-5">
            <!-- Titre de la page -->
            <div class="text-center mb-4">
                <h1 class="display-5 text-danger">Gestion de votre compte</h1>
                <p class="text-light">Consultez vos informations et gérez vos opérations.</p>
            </div>

            <!-- Section Profil Utilisateur -->
            <div class="card mb-4">
                <div class="card-body">
                    <h5 class="card-title">Informations Compte</h5>
                    <c:if test="${not empty compte}">
                        <p class="card-text">
                            <strong>Nom :</strong> ${compte.name}<br>
                            <strong>Solde :</strong> ${compte.solde} €
                        </p>
                    </c:if>
                </div>
            </div>

            <!-- Actions utilisateur -->
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Actions disponibles</h5>
                    <form id="actionForm" method="POST" action="controleur">
                        <div class="mb-3">
                            <label for="debitAmount" class="form-label">Débiter un montant :</label>
                            <input type="number" class="form-control" id="debitAmount" name="debitAmount" min="0" step="0.01" required>
                        </div>
                        <button type="submit" class="btn btn-danger" name="action" value="debiter">Débiter</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <div class="footer">
            <p>&copy; 2025 Cinema Reservation. Tous droits réservés.</p>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
