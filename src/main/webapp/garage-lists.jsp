<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >


<title>Garage List</title>
</head>
<body>
<div class="container">
<h2>Garage List</h2>

<form method = "post" action = "GarageNavigationServlet" >
<table class="table table-striped table-hover">
	<tr> 
		<th></th>
		<th><h3>Garage Name</h3></th>
		<th><h3>Garage Owner</h3> </th>
		<th><h3>Owner Email</h3> </th>
		<th><h3>Cars in Garage</h3></th>
	</tr>
<c:forEach items="${requestScope.allGarages}" var="currentGarage">
	<tr>
   		<td><input type="radio" name="id" value="${currentGarage.id}" ></td>
   		<td>${currentGarage.garageName}</td>
   		<td>${currentGarage.garageOwner.name}</td>
   		<td>${currentGarage.garageOwner.email}</td>
  		<td> 
  			<table>
  				<tr>
  					<c:forEach items="${currentGarage.cars}" var="car">
  						<td>${car.make} - ${car.model}: ${car.year}</td>
  					</c:forEach>
  				</tr>
  			</table>
  		</td>
    </tr>
</c:forEach>
</table>
<br />
<input type = "submit" value = "edit" name="doThisToGarage" class="btn btn-warning">
<input type = "submit" value = "delete" name="doThisToGarage" class="btn btn-danger">
<input type="submit" value = "add" name = "doThisToGarage" class="btn btn-success">

</form>
<a href = "index.html"><input type="button" value="Home"></a>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>

</div>
</body>
</html>