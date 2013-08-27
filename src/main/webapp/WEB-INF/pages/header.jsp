<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




	<div class="span3" id="logo">

		<a> <img src="/WEB-INF/Image/Treeptik.Eval.jpg" /></a>
		<img src="<c:url value="/WEB-INF/images/Treeptik.Eval.jpg" />" />
	</div>

	<div class="span9" id="logo">
		<center >
			<h1>Location de voiture</h1>
			<br /> <a 
				href="<c:url value="/location-voiture/j_spring_security_logout"/>">Déconnexion</a>
			<br /> <br /> <br />
		</center>

	</div>
