<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uploader un fichier</title>
</head>
<body>
	<c:if test="${ !empty fichier }">
		<p>
			<c:out value="Le fichier ${ fichier } (${ description }) à bien été uploader"></c:out>
		</p>
	</c:if>
	<form enctype="multipart/form-data" method="post" action="fichier">
		<p>
			<label for="description">Description du fichier : </label>
			<input type="text" name="description" id="description" />
		</p>
		<p>
			<label for="fichier">Fichier à envoyer : </label>
			<input type="file" name="fichier" id="fichier" />
		</p>
		<input type="submit" />
	</form>
</body>
</html>