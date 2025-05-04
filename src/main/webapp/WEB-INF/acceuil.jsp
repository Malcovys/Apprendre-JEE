<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil</title>
</head>
<body>
	<%-- LIRE UNE SESSION
		<c:if test="${ !empty sessionScope.nom && !empty sessionScope.prenom }">
			<p>Vous êtes ${ sessionScope.nom } ${ sessionScope.prenom } !</p>
		</c:if> 
	--%>
	
	<c:out value="${ prenom }" />

	<form method="post" action="acceuil">
		<p>
			<label for="nom">Nom : </label>
			<input type="text" name="nom" id="nom" />
		</p>
		<p>
			<label for="prenom">Prénom : </label>
			<input type="text" name="prenom" id="prenom" />
		</p>
		<input type="submit" />
	</form>
</body>
</html>