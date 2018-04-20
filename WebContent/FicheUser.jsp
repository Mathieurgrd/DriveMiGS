<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Fiche Utilisateur</title>
	<meta charset="UTF-8" lang="fr">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="maketrajet.css">
</head>
<body>
	<div class="wrapper">
		<form class="form-signin" method="POST" action="SignIn">
			<h2 class="form-signin-heading">Fiche Utilisateur</h2>
			<label for="depart">Rechercher un utilisateur</label><br>
			<input type="text" class="form-control" name="depart" placeholder="Nelson Alex"/><br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Rechercher</button>
			<a href="">Retour</a>
		</form>
	</div>

</body>
</html>