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

<title>Edit Car</title>
</head>
<body>
<div class="container">
<h2>Edit This Car </h2>
<small class="text-muted">Make changes to the make , model or year</small>
<br />
<form action = "EditCarServlet" method="post">

<div class="form-group">
<label for="make">Make:</label><input type ="text" name = "make" value= "${carToEdit.make}"><br />
</div>

<div class="form-group">
<label for="model">Model:</label>
<input type = "text" name = "model"  value= "${carToEdit.model}"><br />
</div>

<div class="form-group">
<label for="year">Year:</label>
<input type = "text" name = "year"  value= "${carToEdit.year}"><br />
</div>

<input type = "hidden" name = "id" value="${carToEdit.id}">
<input type = "submit" value="Save Edited Car" class="btn btn-primary">
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
</div>

</body>
</html>