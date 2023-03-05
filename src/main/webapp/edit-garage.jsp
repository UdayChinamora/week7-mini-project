<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >

<title>Edit Owner</title>
</head>
<body>
<div class="container">
<h2>Edit Owner </h2>
<small class="text-muted">Making changes to this garage</small>
<br />
<form action = "EditGarageServlet" method="post">
<div class="form-group">
<label for="garageTitle">Garage Title:</label>
<input type="text" name="garageTitle" value="${garageToEdit.garageName}" required><br />
</div>

<div class="form-group">
<label for="name">Owners Name:</label>
<input type = "text" name = "name" value="${garageToEdit.garageOwner.name}" required><br />
</div>

<div class="form-group">
<label for="email">Owners email:</label>
<input type = "text" name = "email" value="${garageToEdit.garageOwner.email}" required><br />
</div>

<input type="hidden" name="ownerId" value="${garageToEdit.garageOwner.id}">
<input type="hidden" name="id" value="${garageToEdit.id}"> 

<label>Select cars to put in garage:</label><br>
<select multiple name="carsInGarage">
	<c:forEach items="${requestScope.allCars}" var="currCar">
		<option value="${currCar.id}">${currCar.make} - ${currCar.model}: ${currCar.year}</option> 
	</c:forEach>
</select>
<br>


<input type="submit" value="Add Garage">
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
</div>

</body>
</html>