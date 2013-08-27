<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--     ajouter une directive de page pour pouvoir utiliser des balises -->

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list voitures</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<h1>Liste des voitures</h1>
	<br />




	<table border="1" bordercolor="red">
		<tr>
			<th>ID</th>
			<th>Marque</th>
			<th>Modele</th>
			<th>Date Mise En Circulation</th>

		</tr>
		<c:forEach items="${listVoitures}" var="v">
			<tr align=center>
				<td>${v.id}</td>
				<td>${v.marque}</td>
				<td>${v.model}</td>
				<td>${v.dateMiseEnCirculation}</td>
				<td><a href="modifier.do?id=${v.id}">Modifier</a></td>
				<td><a href="supprimer.do?id=${v.id}">Supprimer</a></td>
			</tr>



		</c:forEach>
	</table>
	
	<br/>
	<div>
		<a href="voiture.do">Ajouter une nouvelle voiture</a>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>