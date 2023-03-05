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

<title>Edit Owner</title>
</head>
<body>
<div class="container">
<h2>Edit Owner </h2>
<small class="text-muted">Making changes to this owner</small>
<br />
<form action = "EditOwnerServlet" method="post">

<div class="form-group">
<label for="name">Name:</label>
<input type ="text" name = "name" value= "${ownerToEdit.name}"><br />
</div>

<div class="form-group">
<label for="email">Email:</label>
<input type = "text" name = "email"  value= "${ownerToEdit.email}"><br />
</div>

<input type = "hidden" name = "id" value="${ownerToEdit.id}">
<input type = "submit" value="Save Owner" class="btn btn-primary">
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
</div>

</body>
</html>