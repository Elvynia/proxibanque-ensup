<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<body>
	<h1>Vous êtes sur la page des comptes de Jean Neymar</h1>
	<table class="table table-striped table-dark">
	  <thead>
		<tr>
		  <th scope="col">N°</th>
		  <th scope="col">Type</th>
		  <th scope="col">Solde</th>
		</tr>
	  </thead>
	  <tbody>
		<c:forEach items="${listeComptes}" var="compte">
			<tr>
				<td>${compte.numCompte}</td>
				<td>
					<c:choose>
						<c:when test="${compte.type}">
							COURANT
						</c:when>
						<c:otherwise>
							EPARGNE
						</c:otherwise>
					</c:choose>
				</td>
				<td>${compte.solde}</td>
			</tr>
		</c:forEach>
	  </tbody>
	<table>
</body>
</html>