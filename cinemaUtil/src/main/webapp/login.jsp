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

        #loginSection {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.85);
            z-index: 9999;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-card {
            backdrop-filter: blur(8px);
            background-color: rgba(255, 255, 255, 0.05);
            border: 1px solid rgba(255, 255, 255, 0.2);
            border-radius: 15px;
            padding: 30px;
            color: white;
            width: 100%;
            max-width: 400px;
        }

        .login-card h5 {
            color: #ff0000;
            text-align: center;
            margin-bottom: 20px;
        }

        .form-control {
            background-color: rgba(255, 255, 255, 0.1);
            border: 1px solid rgba(255, 255, 255, 0.3);
            color: white;
        }

        .form-label {
            color: #fff;
        }

        .form-control::placeholder {
            color: #ccc;
        }

        .btn-primary {
            background-color: #ff0000;
            border-color: #ff0000;
        }

        .btn-primary:hover {
            background-color: #cc0000;
            border-color: #cc0000;
        }

        .alert-danger {
            background-color: rgba(255, 0, 0, 0.8);
            border: none;
            color: white;
        }
    </style>
</head>
<body>
<!-- Login Section -->
<div class="<c:if test='${not sessionScope.isLoggedIn}'>d-flex</c:if> <c:if test='${sessionScope.isLoggedIn}'>d-none</c:if>" id="loginSection">
    <div class="login-card">
        <h5>LOGIN</h5>
        <form id="loginForm" method="POST" action="controleur">
            <div class="mb-3">
                <label for="AccountName" class="form-label">Nom :</label>
                <input type="text" class="form-control" id="AccountName" name="name" placeholder="Votre nom" required>
            </div>
            <div class="mb-3">
                <label for="AccountPass" class="form-label">Mot de passe :</label>
                <input type="password" class="form-control" id="AccountPass" name="password" placeholder="Mot de passe" required>
            </div>
            <button type="submit" class="btn btn-primary w-100" name="action" value="login">LOGIN</button>
            <c:if test="${not empty errorMsg}">
                <div class="alert alert-danger mt-3">${errorMsg}</div>
            </c:if>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
