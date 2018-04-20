<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
              
		 <c:choose>
           <c:when test="${trajetStatus}">
                <input type="text" class="form-control"  placeholder="Votre Point de Départ" 
                id="user_input_autocomplete_address" value="${lastTrajet.getAddress()}" name="user_input_autocomplete_address">
  		
  				 
           </c:when>
         	<c:otherwise>
     
        <input type="text" class="form-control"  placeholder="Votre Point de Départ" id="user_input_autocomplete_address" >
                  
           </c:otherwise>
       </c:choose>
    </div>

    <br>

    <div>
        <button onclick="initialize()" type="button" class="btn btn-danger">
            Rechercher
    </div>

    <br>

    <div>
    <c:choose>
            <c:when test="${userStatus}">
	         <c:import url="travelList.jsp" />

            </c:when>
            <c:otherwise>
               <div>3 itinéraires autour de vous</div>
            </c:otherwise>
        </c:choose>

    </div>
	    
	<div class="newRide">
	    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
	         Proposer un trajet
	    </button>
	</div>
    
    <!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Proposer un trajet<h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
         <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="wrapper">
		    <form class="form-signin" method="POST" action="Maketrajet">
		        <label for="depart">Lieu de départ :</label><br>
		        <input type="text" class="form-control"  placeholder="Départ" id="user_input_autocomplete_address" name="user_input_autocomplete_address" >         <br>
		        <label for="depart">Lieu d'arrivée :</label><br>
		        <input type="text" class="form-control" name="arriver" placeholder="186 Route de Grenade, 31700 Blagnac" disabled="disabled"/><br>
		        <label for="depart">Date et Heure du départ:</label><br>
		        
		        <div class="container">
		            <div class="row">
		                <div class='col-sm-6'>
		                    <div class="form-group">
		                        <div class='input-group date' id='datetimepicker1'>
		                            <input type='date' class="form-control" name="dateDepart" />
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
		            <input type="time" name="wakeup"/>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
		          <button type="submit" class="btn btn-primary">Soumettre</button>
		        </div>
		    </form>
         </div>
      </div>
    </div>
  </div>
</div>
    
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=places&amp;key=AIzaSyDW5yHAL_4hi2cVafivQKfrV0r_Kixo3NM"></script>
    <script type="text/javascript" src="js/autocomplete.js"></script>
    
</body>
</html>