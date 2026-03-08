<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Historique des Déclarations</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<jsp:include page="/WEB-INF/views/navbar.jsp" />

<div class="p-8">
    <div class="max-w-6xl mx-auto bg-white p-6 rounded shadow">
        <h2 class="text-xl font-bold mb-4">Historique des Déclarations Mensuelles</h2>

        <table class="w-full text-left border-collapse">
            <thead>
            <tr class="bg-gray-200">
                <th class="p-3 border">ID</th>
                <th class="p-3 border">Employeur</th>
                <th class="p-3 border">Période (Mois/Année)</th>
                <th class="p-3 border">Date de déclaration</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="declaration" items="${declarations}">
                <tr class="hover:bg-gray-50">
                    <td class="p-3 border">${declaration.id}</td>
                    <td class="p-3 border">${declaration.employeur.raisonSociale}</td>
                    <td class="p-3 border">${declaration.mois} / ${declaration.annee}</td>
                    <td class="p-3 border">${declaration.dateDeclaration}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>