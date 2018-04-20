<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div>
        <table id="table" border="1">

            <!-- The Row Number 0 -->
        
			<tr>
				<th>Nom</th>
				<th>Point de départ</th>
				<th>Date</th>
				<th>Heure de départ</th>
			</tr>
	
		<c:forEach var="trajet" items="${sessionScope.trajets}"> 	
			<c:choose>
				<c:when test="${sessionScope.users==null}">>
				
				</c:when>
				<c:otherwise>
				
					<tr>
						<td> ${ trajet.value.getTransportDriver().getName() }</td>
						<td> ${ trajet.value.getAddress() }</td>
						<td> ${ trajet.value.getDateDepart() }</td>
						<td> ${ trajet.value.getHeureDepart() }</td>
						
					</tr>
				
				</c:otherwise>
			</c:choose>
		</c:forEach> 	
	</table>

       </div>
       <!-- 
                <script type="text/javascript" src="js/travelList.js"></script>
        -->
       
</body>
</html>