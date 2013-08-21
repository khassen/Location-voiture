<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     ajouter une directive de page pour pouvoir utiliser des balises -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Saisie Voiture</h1>
	<br />

	<form:form action="voiture.do"  commandName="voiture" method="POST" >

		<table>

			<tr>
				<td>Marque:</td>
<!-- 				ici c du spring -->
				<td><form:input path="marque" /> </td>
			</tr>

			<tr>
				<td>Modele:</td>
				<td><form:input path="model" /></td>

			</tr>
			<tr>
				<td colspan="2"><input type="submit"  name="Valider"
					value="valider"></td>
			</tr>

		</table>

	</form:form>
</body>
</html>