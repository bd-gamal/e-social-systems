<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Employeurs</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-8">
<jsp:include page="/WEB-INF/views/navbar.jsp" />

<div class="max-w-6xl mx-auto space-y-8">

    <div class="bg-white p-6 rounded shadow">
        <h2 class="text-xl font-bold mb-4">Ajouter un Employeur</h2>
        <form action="${pageContext.request.contextPath}/employeurs?action=create" method="POST" class="flex gap-4 items-end">
            <div class="flex-1">
                <label class="block text-sm font-bold text-gray-700">Raison Sociale</label>
                <input type="text" name="raisonSociale" required class="mt-1 w-full border p-2 rounded">
            </div>
            <div class="flex-1">
                <label class="block text-sm font-bold text-gray-700">Secteur d'Activité</label>
                <input type="text" name="secteurActivite" required class="mt-1 w-full border p-2 rounded">
            </div>
            <button type="submit" class="bg-green-600 text-white px-6 py-2 rounded hover:bg-green-700">Ajouter</button>
        </form>
    </div>

    <div class="bg-white p-6 rounded shadow">
        <h2 class="text-xl font-bold mb-4">Liste des Employeurs</h2>
        <table class="w-full text-left border-collapse">
            <thead>
            <tr class="bg-gray-200">
                <th class="p-3 border">ID</th>
                <th class="p-3 border">Raison Sociale</th>
                <th class="p-3 border">Secteur d'Activité</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="emp" items="${employeurs}">
                <tr class="hover:bg-gray-50">
                    <td class="p-3 border">${emp.id}</td>
                    <td class="p-3 border">${emp.raisonSociale}</td>
                    <td class="p-3 border">${emp.secteurActivite}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>