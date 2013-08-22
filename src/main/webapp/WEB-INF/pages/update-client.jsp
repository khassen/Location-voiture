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

	<h1>Modifier Client</h1>
	<br />

	<form:form action="update.do" commandName="client" method="POST">

		<form:hidden path="id" />

		<table>
			<tr>
				<td>Nom :</td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td>Prenom :</td>
				<td><form:input path="prenom" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Valider" /></td>
			</tr>
		</table>

		<br />

		<a href="clients.do">Retour à la liste des voitures</a>

	</form:form>

</body>
</html>