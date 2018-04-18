<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="css/search.css" />
</head>
<body>
    <div>
        <label for="email">Votre point de départ</label>
        <input type="text" class="form-control"  placeholder="Votre Point de Départ" name="user_input_autocomplete_address" >
    </div>
    
    </br>
    
    <div>
        <button onclick="initialize()" type="button" class="btn btn-danger">Rechercher</button>
    </div>
    
    </br>
    
    <div>
        <p>3 trajets disponibles autour de vous</p>
    </div>
    <div class="newRide">
       <a type="button" class="btn btn-primary newRide" href="maketrajet.jsp">Proposer un trajet</a>
    </div>
    <script type="text/javascript" src="js/autocomplete.js"></script>
    
</body>
</html>