<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page Introuvable - e-Social Systems</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
<div class="text-center">
    <h1 class="text-9xl font-bold text-blue-600">404</h1>
    <p class="text-2xl font-semibold text-gray-800 mt-4">Oups ! Page introuvable.</p>
    <p class="text-gray-500 mt-2">La page que vous recherchez n'existe pas ou a été déplacée.</p>
    <a href="${pageContext.request.contextPath}/" class="mt-6 inline-block bg-blue-600 text-white px-6 py-3 rounded shadow hover:bg-blue-700 transition">
        Retour à l'accueil
    </a>
</div>
</body>
</html>
