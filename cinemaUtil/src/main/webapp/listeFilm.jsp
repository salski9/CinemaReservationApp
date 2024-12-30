<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Films</title>
</head>
<body>
    <h1>Liste des films</h1>

    <!-- Button to reload the page and fetch updated film data -->
    <button onclick="location.reload()">Afficher les films</button>

    <br><br>

    <table border="1" cellpadding="5" cellspacing="0"
           style="border-collapse: collapse; width: 80%;" bordercolor="#111111">
        <thead>
            <tr bgcolor="#0000FF" style="color: white;">
                <th>ID de Film</th>
                <th>Nom de Film</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty TousLesFilms}">
                <c:forEach var="c" items="${TousLesFilms}">
                    <tr>
                        <td><c:out value="${c.iDFilm}"/></td>
                        <td><c:out value="${c.nomFilm}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            
        </tbody>
    </table>
</body>
</html>
