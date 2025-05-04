<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonjour</title>
</head>
<body>
	
	<c:if test="${ !empty form.resultat }" >
		<p><c:out value="${ form.resultat }" /></p>
	</c:if>

	<form method="post" action="bonjour">
		<p>
			<label for="nom">Nom : </label>
			<input type="text" name="nom" id="nom" />
		</p>
		<p>
			<label for="prenom">Prénom : </label>
			<input type="text" name="prenom" id="prenom" />
		</p>
		<input type="submit"/>
	</form>
	
	<ul>
		<c:forEach var="utilisateur" items="${ utilisateurs }">
			<li><c:out value="${ utilisateur.nom }" /> <c:out value="${ utilisateur.prenom }" /></li>
		</c:forEach>
	</ul>
</body>
</html>