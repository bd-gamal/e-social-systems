<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Connexion - e-Social</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 flex items-center justify-center h-screen">
<div class="bg-white p-8 rounded-lg shadow-md w-96">
  <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">e-Social Systems</h2>

  <c:if test="${not empty erreur}">
    <div class="bg-red-100 text-red-700 p-3 rounded mb-4 text-sm">${erreur}</div>
  </c:if>

  <form action="${pageContext.request.contextPath}/login" method="POST" class="space-y-4">
    <div>
      <label class="block text-gray-700 text-sm font-bold mb-2">Nom d'utilisateur</label>
      <input type="text" name="username" required class="w-full px-3 py-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-500">
    </div>
    <div>
      <label class="block text-gray-700 text-sm font-bold mb-2">Mot de passe</label>
      <input type="password" name="password" required class="w-full px-3 py-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-500">
    </div>
    <button type="submit" class="w-full bg-blue-600 text-white font-bold py-2 px-4 rounded hover:bg-blue-700 transition">
      Se connecter
    </button>
  </form>
</div>
</body>
</html>