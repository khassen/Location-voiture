<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--     ajouter une directive de page pour pouvoir utiliser des balises -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/pages/header.jsp" %>
	<h1>Afficher Voiture</h1>
	<br /> ${voiture.marque} ${voiture.model}
	
	<%@ include file="/pages/footer.jsp" %>
</body>
</html>