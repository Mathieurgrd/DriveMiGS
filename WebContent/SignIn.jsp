<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Connexion</title>
    <meta charset="UTF-8" lang="fr">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/signIn.css">
</head>

<body>
<div class="wrapper">
    <form class="form-signin" method="POST" action="SignIn">
        <h2 class="form-signin-heading">S'identifier</h2>
        <span class="error">${errors['noUser']}</span>
        <input type="text" class="form-control" name="email" placeholder="Email" required="true" /><br><span class="error">${errors['email']}</span><br>
        <input type="password" class="form-control" name="pwd1" placeholder="Mot de passe" required="true"/><br><span class="error">${errors['pwd1']}</span><br>

        <label class="checkbox">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Rester connecté
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
        <a href="">Création de compte</a>
    </form>
</div>
</body>
</html>