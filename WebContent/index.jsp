<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DriveMiGS</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a
			class="navbar-brand" href="#">DriveMiGS</a> <c:choose>
			<c:when test="${userStatus}">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown profil"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> ${user.getFirstName()} </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Modifier mon compte</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="" data-toggle="modal"
                                data-target="#disconnect">Deconnexion</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" data-toggle="modal"
								data-target="#removeAccount" href="">Supprimer mon compte</a>
						</div></li>
				</ul>


			</c:when>
			<c:otherwise>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="navbar-brand "
						href="<c:url value="SignUp"/>">S'inscrire</a></li>
					<li class="navbar-item"><a class="btn btn-primary"
						href="<c:url value="SignIn"/>" role="button">Connexion</a></li>
				</ul>
			</c:otherwise>
		</c:choose> </nav>

	</div>

	<div class="container">
		<div class="row">
			<div class="col">
				<c:import url="map.jsp" />
			</div>
			<div class="col search">
				<c:import url="search.jsp" />
			</div>
		</div>
	</div>

	<!-- Modal Remove Account -->
	<div class="modal fade" id="removeAccount" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Supprimer</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Etes-vous sûre de vouloir quitter
					l'aventure DriveMiGS ?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Non</button>
					<a href="<c:url value="SignOut"/>"><button type="button"
							class="btn btn-primary">Oui</button></a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal Disconnect -->
    <div class="modal fade" id="disconnect" tabindex="-1" role="dialog"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Deconnexion</h5>
                    <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">Etes-vous sûre de vouloir vous déconnecter ?</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                        data-dismiss="modal">Non</button>
                    <a href="<c:url value="LogOut"/>"><button type="button"
                            class="btn btn-primary">Oui</button></a>
                </div>
            </div>
        </div>
    </div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</html>