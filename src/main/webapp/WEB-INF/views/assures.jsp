<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Assurés</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-8">
<div class="max-w-6xl mx-auto space-y-8">

    <div class="bg-white p-6 rounded shadow">
        <h2 class="text-xl font-bold mb-4">Ajouter un Assuré</h2>
        <form action="${pageContext.request.contextPath}/assures?action=create" method="POST" class="grid grid-cols-4 gap-4 items-end">
            <div>
                <label class="block text-sm font-bold text-gray-700">Nom complet</label>
                <input type="text" name="nom" required class="mt-1 w-full border p-2 rounded">
            </div>
            <div>
                <label class="block text-sm font-bold text-gray-700">Salaire Mensuel (DH)</label>
                <input type="number" step="0.01" name="salaire" required class="mt-1 w-full border p-2 rounded">
            </div>
            <div>
                <label class="block text-sm font-bold text-gray-700">Employeur</label>
                <select name="employeurId" required class="mt-1 w-full border p-2 rounded bg-white">
                    <c:forEach var="emp" items="${employeurs}">
                        <option value="${emp.id}">${emp.raisonSociale}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Enregistrer</button>
        </form>
    </div>

    <div class="bg-white p-6 rounded shadow">
        <h2 class="text-xl font-bold mb-4">Liste des Assurés</h2>
        <table class="w-full text-left border-collapse">
            <thead>
            <tr class="bg-gray-200">
                <th class="p-3 border">ID</th>
                <th class="p-3 border">Nom</th>
                <th class="p-3 border">Salaire</th>
                <th class="p-3 border">Employeur</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="assure" items="${assures}">
                <tr class="hover:bg-gray-50">
                    <td class="p-3 border">${assure.id}</td>
                    <td class="p-3 border">${assure.nom}</td>
                    <td class="p-3 border">${assure.salaireMensuel} DH</td>
                    <td class="p-3 border">${assure.employeur.raisonSociale}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<jsp:include page="/WEB-INF/views/navbar.jsp" />
</html>