<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/pages/header.jsp" %>
	<h1>Liste des reservations:</h1>
	<br />


	<table border="1" bordercolor="red">
		<tr>
			<th>Date Prise</th>
			<th>Date Retour</th>
			<th>Date Reservation</th>
			<th>Nom Client</th>
			<th>Prenom Client</th>
			<th>Moarque Voiture</th>
			<th>Modele Voiture</th>

		</tr>
		<c:forEach items="${listReservations}" var="l">
			<tr align=center>
				<td>${l.datePrise}</td>
				<td>${l.dateRetour}</td>
				<td>${l.dateResev}</td>
				<td>${l.client.nom}</td>
				<td>${l.client.prenom}</td>
				<td>${l.voiture.marque}</td>
				<td>${l.voiture.model}</td>
				<td><a href="update-reservation.do?id=${l.id}">Modifier</a></td>
				<td><a href="delete-reservation.do?id=${l.id}">Supprimer</a></td>
			</tr>



		</c:forEach>
	</table>
<%@ include file="/pages/footer.jsp" %>

</body>
</html>