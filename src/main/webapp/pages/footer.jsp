<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%!int pageCount = 0; void addCount() {pageCount++;}%>
<%addCount();%>

	<center>
		<p>Merci pour votre visite</p>
			<p>
La page a été visitée <%=pageCount%> fois.
</p>
	</center>
