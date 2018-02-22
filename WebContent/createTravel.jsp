<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
    <form class="form-signin" method="POST" action="CreateTravel">
        <h2 class="form-signin-heading">Proposer une trajet</h2>
        <input type="date" class="form-control" name="date" placeholder="Date du départ" required="true" /><span class="error">${errors['date']}</span>
        <input type="datetime-local" class="form-control" name="heure" placeholder="Heure du départ" required="true"/><span class="error">${errors['hour']}</span>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Proposer mon trajet</button>
        <a href="/index.jsp">Retour à l'accueil</a>
    </form>
</div>
</body>
</html>
