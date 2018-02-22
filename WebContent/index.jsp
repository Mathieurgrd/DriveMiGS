<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pimp my ride</title>
</head>
<body>
COUCOUCOUCOCUUCUOCUCOUIOEJFBKJEJFKJ</body><br>
	<!-- <a href="SignUp.jsp">M'inscrire</a> -->	
		<a href="<c:url value="SignUp"/>">M'inscrire</a>

	<c:if  test="${userStatus}">
			<p>Nom : ${ user.getName() }</p><br>
			<p>Prenom : ${user.getFirstName()}</p>
	</c:if>

		



</html>