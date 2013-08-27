<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<center>
		<table border=10 width=60% color="green" size="10" >

			<tr>

				<td align=center><a href="voiture.do">Ajouter une nouvelle
						voiture</a></td>

			</tr>

			<tr>
				<td align=center><a href="voitures.do">Afficher la liste des voitures</a></td>
			</tr>

			<tr>
				<td align=center><a href="client.do">Ajouter une nouveau client</a></td>
			</tr>

			<tr>
				<td align=center><a href="clients.do">Afficher la liste des clients</a></td>
			</tr>

			<tr>
				<td align=center><a href="reservation.do">Ajouter une nouvelle
						reservation</a></td>
			</tr>

			<tr>
				<td align=center><a href="reservations.do">Afficher la liste des
						reservations</a></td>
			</tr>
		</table>
	</center>

	<br />
	<%@ include file="footer.jsp"%>
</body>
</html>