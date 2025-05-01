<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Vous êtes sur testsession.jsp</p>
	<c:if test="${ !empty sessionScope.nom && !empty sessionScope.prenom }">
		<p>Vous êtes ${ sessionScope.nom } ${ sessionScope.prenom } !</p>
	</c:if>
</body>
</html>