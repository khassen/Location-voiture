<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/pages/header.jsp"%>
	<h1>Modifier reservation</h1>
	<br />

	<form:form action="update-reservation.do" modelAttribute="reservation"
		method="POST">

		<form:hidden path="id" />

		<table>
			<tr>
				<td>Date Reservation :</td>
				<td><form:input path="dateResev" /></td>
			</tr>
			<tr>
				<td>Date Prise :</td>
				<td><form:input path="datePrise" /></td>
			</tr>
			<tr>
				<td>Date Retour :</td>
				<td><form:input path="dateRetour" /></td>
			</tr>

			<tr>
				<td>Client:</td>
				<td><form:select path="client.id">
						<c:forEach var="client" items="${clients}">
							<form:option value="${client.id}">
							${client.nom} ${client.prenom}
                            </form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>Voiture:</td>
				<td><form:select path="voiture.id">
						<c:forEach var="voiture" items="${voitures}">
							<form:option value="${voiture.id}">
                                ${voiture.marque} ${voiture.model}
                             </form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Valider" /></td>
			</tr>
		</table>

		<br />

		<a href="reservations.do">Retour à la liste des voitures</a>

	</form:form>


	<%@ include file="/pages/footer.jsp"%>



</body>
</html>