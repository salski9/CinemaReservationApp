<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Gestion des Films</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        #filmTable {
            display: none; /* Cache initialement la table des films */
        }
        .container {
            margin-top: 20px;
        }
        .btn-primary {
            margin-right: 10px;
        }
        .table-header {
            background-color: #118dff; /* Bleu primaire */
            color: white;
        }
        .table-row {
            background-color: #f0f8ff; /* Gris très clair pour les lignes */
        }
        body {
            background-color: #f9fcff; /* Gris très clair pour le fond */
        }
        h1 {
            color: #118dff; /* Couleur bleu primaire pour les titres */
        }
        .form-label {
            color: #118dff; /* Bleu pour les étiquettes du formulaire */
        }
        .form-control {
            border-color: #118dff; /* Bordure bleue pour les champs de formulaire */
        }
        .btn-primary {
            background-color: #118dff;
            border-color: #118dff;
        }
        .btn-primary:hover {
            background-color: #0d6efd;
        }
        .btn-secondary {
            background-color: #d3d3d3;
            border-color: #c0c0c0;
        }
        .btn-secondary:hover {
            background-color: #b0b0b0;
        }
    </style>
    <script>
        function toggleFilms() {
            var table = document.getElementById("filmTable");
            var toggleButton = document.getElementById("toggleButton");
            if (table.style.display === "none") {
                table.style.display = "table";
                toggleButton.textContent = "Cacher les films";
            } else {
                table.style.display = "none";
                toggleButton.textContent = "Afficher les films";
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <!-- Liste des films -->
        <h1 class="text-center">Liste des Films</h1>
        <div class="text-center mb-4">
            <button id="toggleButton" class="btn btn-primary" onclick="toggleFilms()">Afficher les films</button>
        </div>

        <div class="table-responsive">
            <table id="filmTable" class="table table-bordered table-hover">
                <thead>
                    <tr class="table-header">
                        <th>ID du Film</th>
                        <th>Nom du Film</th>
                        <th>Realisateur du Film</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty TousLesFilms}">
                        <c:forEach var="c" items="${TousLesFilms}">
                            <tr class="table-row">
                                <td><c:out value="${c.id_film}"/></td>
                                <td><c:out value="${c.nom}"/></td>
                                <td><c:out value="${c.realisateur }"/></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>

        <!-- Ajout d'un Film -->
        <h1 class="text-center text-primary mt-5">Ajout d'un Film</h1>

<div class="container mt-4">
    <form method="POST" action="controleur" class="p-3 border rounded shadow-sm bg-light">
        <div class="row">
            <!-- Colonne de gauche pour les champs du formulaire -->
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="iDFilm" class="form-label">ID du Film</label>
                    <input type="number" id="iDFilm" name="id_film" class="form-control" required />
                </div>
                <div class="mb-3">
                    <label for="nomFilm" class="form-label">Nom du Film</label>
                    <input type="text" id="nomFilm" name="nom" class="form-control" required />
                </div>
                <div class="mb-3">
                    <label for="realisateurFilm" class="form-label">Realisateur du Film</label>
                    <input type="text" id="realisateurFilm" name="realisateur" class="form-control" required />
                </div>
                <div class="text-center">
                    <button type="submit" value="ajouter" name="action" class="btn btn-primary">Ajouter</button>
                    <button type="reset" value="Reset" name="reset" class="btn btn-secondary">Reset</button>
                </div>
            </div>
            
            <!-- Colonne de droite pour l'image -->
            <div class="col-md-6 d-flex align-items-center justify-content-center">
                <figure class="text-center">
                    <img src="images/addFilm.jpg" alt="Add Film Image" class="img-fluid rounded" style="max-width: 100%; height: auto; max-height: 300px;">
                </figure>
            </div>
        </div>
    </form>
</div>

<!-- Bootstrap JS et Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>




</html>
