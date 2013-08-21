<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Modifier Voiture</h1>
	<br />

	<form:form action="modifier.do" commandName="voiture" method="POST">

	           <input type="text" name="Marque" >${v.marque}<br/>
	           <input type="text" name="Modele">${v.model}<br/>
	


               <input type="submit" name="Valider"
					value="valider">


	</form:form>



</body>
</html>