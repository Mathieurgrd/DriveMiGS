<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Fiche de notation</title>
	<meta charset="UTF-8" lang="fr">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="maketrajet.jsp">
    <link rel="stylesheet" href="FicheNotation.css">
</head>
<body>
	<div class="wrapper">
		<form class="form-signin" method="POST" action="SignIn">
			<h2 class="form-signin-heading">Fiche de notation</h2>
			<label for="nom">Nom :</label><br>
			<input type="text" class="form-control" name="nom" placeholder="Nelson" disabled="disabled"/><br>
			<label for="prenom">Prenom :</label><br>
			<input type="text" class="form-control" name="prenom" placeholder="Alex" disabled="disabled"/><br>
			<label for="note">Note :</label><br>
			
		 	
				<input type="radio"  name="star" checked="true"/>
				<label for="1">1</label>
				<img src="etoile.jpg" />
				<label for="1">&nbsp</label>
				
				<input type="radio"  name="star" /> 
				<label for="2">2</label>
				<img src="etoile.jpg" />
				<label for="1">&nbsp</label>
				
				<input type="radio"  name="star" />
				<label for="3">3</label>
				<img src="etoile.jpg" />
				<label for="1">&nbsp</label>
				
				<input type="radio"  name="star" />
				<label for="4">4</label>
				<img src="etoile.jpg" />
				<label for="1">&nbsp</label>
				
				<input type="radio"  name="star" />
				<label for="5">5</label>
				<img src="etoile.jpg" />
		
			     
			<button class="btn btn-lg btn-primary btn-block" type="submit">Soumettre</button>
        	<a href="">Retour</a>
		</form>
	</div>
</body>
</html>