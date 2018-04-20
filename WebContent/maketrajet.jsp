<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Proposer un trajet</title>
	<meta charset="UTF-8" lang="fr">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/maketrajet.css">
</head>

<body>
<div class="wrapper">
    <form class="form-signin" method="POST" action="Maketrajet">
        <h2 class="form-signin-heading">Proposer un trajet</h2>
        <label for="depart">Lieu de départ :</label><br>
        <input type="text" class="form-control" name="user_input_autocomplete_address" placeholder="Départ"/><br>
        
        <label for="depart">Lieu d'arrivée:</label><br>
        <input type="text" class="form-control" name="arriver" placeholder="186 Route de Grenade, 31700 Blagnac" disabled="disabled"/><br>
        <label for="depart">Date et Heure du départ:</label><br>
        
		<div class="container">
		    <div class="row">
		        <div class='col-sm-6'>
		            <div class="form-group">
		                <div class='input-group date' id='datetimepicker1'>
		                    <input type='date' name='dateDepart' class="form-control" />
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>
		                </div>
		            </div>
		        </div>
		        <script type="date/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker();
		            });
		        </script>
		    </div>
		</div>
		
		<input type="time" name="wakeup"/><br><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Soumettre</button>
        <a href="">Retour</a>
    </form>
</div>

<script type="text/javascript" src="js/autocomplete.js"></script>

</body>
</html>