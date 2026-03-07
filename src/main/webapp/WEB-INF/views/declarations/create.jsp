<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Nouvelle Déclaration</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-8">
<div class="max-w-xl mx-auto bg-white p-8 rounded shadow-md">
    <h2 class="text-2xl font-bold mb-6 text-gray-800">Faire une Déclaration Mensuelle</h2>

    <c:if test="${not empty erreur}">
        <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
                ${erreur}
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/declarations" method="POST" class="space-y-4">
        <div>
            <label class="block text-sm font-bold text-gray-700">Employeur</label>
            <select name="employeurId" required class="mt-1 w-full border p-2 rounded bg-white">
                <option value="" disabled selected>Choisir un employeur</option>
                <c:forEach var="emp" items="${employeurs}">
                    <option value="${emp.id}">${emp.raisonSociale}</option>
                </c:forEach>
            </select>
        </div>
        <div class="grid grid-cols-2 gap-4">
            <div>
                <label class="block text-sm font-bold text-gray-700">Mois (1-12)</label>
                <input type="number" name="mois" min="1" max="12" required class="mt-1 w-full border p-2 rounded">
            </div>
            <div>
                <label class="block text-sm font-bold text-gray-700">Année</label>
                <input type="number" name="annee" value="2026" required class="mt-1 w-full border p-2 rounded">
            </div>
        </div>

        <div class="bg-blue-50 p-4 rounded text-sm text-blue-800 mt-4">
            <strong>Note :</strong> La validation de ce formulaire calculera et enregistrera automatiquement les cotisations sociales pour tous les assurés de cet employeur.
        </div>

        <button type="submit" class="w-full bg-indigo-600 text-white font-bold py-2 px-4 rounded hover:bg-indigo-700">
            Déclarer et Calculer les Cotisations
        </button>
    </form>
</div>
</body>
</html>