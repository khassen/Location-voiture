<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     ajouter une directive de page pour pouvoir utiliser des balises -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<!-- pour les dates -->
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Location voiture</title>
</head>
<body>
	<%@ include file="/pages/header.jsp"%>
	<center>

	<br />
	<!-- pour pouvoir changer la langue -->
	<fmt:bundle basename="messages" />

	<h1>
		<fmt:message key="saisie-voiture.titre" />
	</h1>

	<br />

	<form:form action="voiture.do" modelAttribute="voiture" method="POST">

		<table>

			<tr>
				<td>Marque:</td>
				<td><form:input path="marque" /><form:errors path="marque" /></td>
			</tr>

			<tr>
				<td>Modele:</td>
				<td><form:input path="model" /> <form:errors path="model" /></td>

			</tr>
			<tr>
				<td>Date Mise En Circulation:</td>
				<td><form:input path="dateMiseEnCirculation" /> <form:errors
						path="dateMiseEnCirculation" /></td>

			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Valider"
					value="valider"></td>
			</tr>

		</table>
		</br>
		<a href="../pages/login.jsp">retour</a>
	</form:form>
	</center>
	<%@ include file="/pages/footer.jsp"%>
</body>
</html>