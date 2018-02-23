<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Modifier mon compte</title>
    <meta charset="UTF-8" lang="fr">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/signUp.css">
</head>

<body>
<div class="wrapper">
    <form class="form-signUp" method="POST" action="UpdateUser">
        <h2 class="form-update-heading">Informations</h2>
                <input type="text" class="form-control" name="firstname" placeholder="${user.getFirstName()}" value="${user.getFirstName()}"/><br>
                <span class="error">${errors['firstname']}</span><br>
                <input type="text" class="form-control" name="name" placeholder="${user.getName()}"  value="${user.getName()}"/><br>
                <span class="error">${errors['name']}</span><br>
                <input type="text" class="form-control" name="email" placeholder="${user.getEmailAdress()}" value="${user.getEmailAdress()}" /><br>
                <span class="error">${errors['email']}</span><br>
        		<input type="text" class="form-control" name="location" placeholder="${user.getLocation()}" value="${user.getLocation()}"  />
        		<input type="password" class="form-control" name="pwd1" placeholder="Mot de passe" value="${user.getPassword()}"/><br>
        		<span class="error">${errors['pwd1']}</span><br>
                <input type="password" class="form-control" name="pwd2" placeholder="Mot de passe" value="${user.getPassword()}" /><br>
                <span class="error">${errors['pwd2']}</span><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">MODIFIER</button>
        <a href="/index.jsp">Annuler et retourner à l'accueil</a>
    </form>
</div>
</body>
</html>




