<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="bg-blue-800 p-4 shadow-md">
    <div class="max-w-6xl mx-auto flex justify-between items-center text-white">
        <div class="text-xl font-bold">e-Social Systems</div>
        <div class="space-x-6">
            <a href="${pageContext.request.contextPath}/employeurs" class="hover:text-blue-300">Employeurs</a>
            <a href="${pageContext.request.contextPath}/assures" class="hover:text-blue-300">Assurés</a>
            <a href="${pageContext.request.contextPath}/declarations?action=create" class="hover:text-blue-300">Faire une Déclaration</a>
            <a href="${pageContext.request.contextPath}/declarations" class="hover:text-blue-300">Historique Déclarations</a>
        </div>
    </div>
</nav>