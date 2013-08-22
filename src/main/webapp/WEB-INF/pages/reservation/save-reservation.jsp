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
	<form:form action="reservation.do" commandName="reservation"
		method="POST">

		<table>

			<tr>
				<td>Date Reservation:</td>
				<td><form:input path="dateReservation" /></td>
			</tr>

			<tr>
				<td>Date Prise:</td>
				<td><form:input path="datePrise" /></td>

			</tr>

			<tr>
				<td>Date Retour:</td>
				<td><form:input path="DateRetour" /></td>

			</tr>
			<tr>
				<td>Client :</td>
				<td><form:select path="client.id" items="${listClients}" /> <form:errors
						path="client" /></td>
			</tr>
			<tr>
				<td>Voiture :</td>
				<td><form:select path="voiture.id" items="${listVoitures}" />
					<form:errors path="voiture" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Valider"
					value="valider"></td>
			</tr>

		</table>

	</form:form>
</body>
</html>