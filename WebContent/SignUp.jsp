<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Inscription</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div class="wrapper">
        <form method="POST" action="SignUp">
            <div class="form-group row">
            <!--  -->
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputFirstName" placeholder="Prénom" name="firstname"><span class="error">${errors['firstname']}</span>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputLastName" placeholder="Nom" name="name"><span class="error">${errors['name']}</span>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email"><span class="error">${errors['email']}</span>
                </div>
            </div>
		     <div class="form-group row">
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputlocation" placeholder="Adresse" name="location"><span class="error">${errors['location']}</span>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" placeholder="Mot de passe" name="pwd1"><span class="error">${errors['pwd1']}</span>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputRepeatPassword" placeholder="Vérification mot de passe" name="pwd2">
                </div>
            </div>
    
            <div class="form-group row">
                <div class="offset-sm-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Inscription</button>
                </div>
            </div>
        </form>
    </div>

</body>
</html>