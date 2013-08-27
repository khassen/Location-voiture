<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<%-- 	<%@ include file="header.jsp"%> --%>
	
	<br/>
	<br/>
	<br/>

	<center>
	<form action="/location-voiture/j_spring_security_check" method="POST">
	
		Login : <input type="text" name="j_username">
		Password : <input type="password" name="j_password"> 
		<input type="submit" value="Login">
		
	</form>
	</center>
	<br/>
	<br/>
	<br/>
<%-- 	<%@ include file="footer.jsp"%> --%>
</body>
</html>