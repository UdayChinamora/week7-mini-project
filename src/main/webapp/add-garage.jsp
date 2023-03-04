<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<meta charset="UTF-8">
<title>Add Garage</title>
</head>
<body>
<div class="container">
<h2>Create Garage</h2>

<form action = "AddOwnerServlet" method="post">
<div class="form-group">
<label for="garageTitle">Garage Title:</label>
<input type="text" name="garageTitle" required><br />
</div>

<div class="form-group">
<label for="name">Owners Name:</label>
<input type = "text" name = "name" required><br />
</div>

<div class="form-group">
<label for="email">Owners email:</label>
<input type = "text" name = "email" required><br />
</div>

<label>Select cars to put in garage:</label><br>
<select multiple>
	<c:forEach items="${requestScope.allCars}" var="currCar">
		<option>${currCar.make} - ${currCar.model}: ${currCar.year}</option> 
	</c:forEach>
</select>
<br>


<input type="submit" value="Add Garage">
</form>
<br />

<a href = "/ViewAllOwnersServlet"><input type="button" value="View the garage List"></a>
<a href = "index.html"><input type="button" value="Home"></a>

<br />
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 
</body>
</html>