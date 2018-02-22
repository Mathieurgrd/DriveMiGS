<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pimp my ride</title>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    
    <div class="header">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
		  <a class="navbar-brand" href="#">DriveMiGS</a>  
		  <c:choose>
                <c:when test="${userStatus}">
                    <ul class="navbar-nav ml-auto">
                        <li class="navbar-item">
                            <a class="navbar-brand" href="" role="">${user.getEmailAdress()}</a>	
                        </li>
                         <li class="nav-item">
                            <a class="navbar-brand " href="<c:url value="LogOut"/>">DECONNEXION</a>
                        </li>
                        <li class="nav-item">
                            <a class="navbar-brand " href="<c:url value="SignOut"/>">SUPPRIMER MON COMPTE</a>
                        </li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="navbar-brand " href="<c:url value="SignUp"/>">S'INSCRIRE</a>
                        </li>
                        <li class="navbar-item">
                            <a class="btn btn-primary" href="<c:url value="SignIn"/>" role="button">CONNEXION</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
		</nav>
    </div>    
    <div class="map">
        <c:import url="map.jsp" />
    </div>
</html>