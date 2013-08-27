<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 	conf a rajotter -->

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1>List des clients</h1>
	<br />

	<form:form action="clients.do" commandName="client" method="GET">

		<table border="1" bordercolor="red">
			<tr>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>

			</tr>

			<c:forEach items="${listClients}" var="c">
				<tr align=center>
					<td>${c.nom}</td>
					<td>${c.prenom}</td>
					<td>${c.email}</td>
					<td><a href="update.do?id=${c.id}">Modifier</a></td>
					<td><a href="delete.do?id=${c.id}">Supprimer</a></td>
				</tr>



			</c:forEach>
		</table>

		<br />
		<div>
			<a href="client.do">Ajouter une nouveau client</a>
		</div>
	</form:form>
	<%@ include file="footer.jsp"%>
</body>
</html>