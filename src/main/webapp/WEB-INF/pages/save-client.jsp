<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<h1>Saisie d'un client</h1>
	<br />

	<form:form action="client.do" commandName="client" method="POST">


		<table>

			<tr>
				<td>Nom</td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><form:input path="prenom" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<td colspan="2"><input type="submit" name="Valider"
				value="valider"></td>
			</tr>

		</table>



	</form:form>

<%@ include file="footer.jsp" %>
</body>
</html>