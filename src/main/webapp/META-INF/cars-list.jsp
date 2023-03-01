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


<title>Cars List</title>
</head>
<body>
<div class="container">
<h2>Cars List</h2>

<form method = "post" action = "navigationServlet" >
<table class="table table-striped table-hover">
<c:forEach items="${requestScope.allCars}" var="currentcar">
<tr>
   <td><input type="radio" name="id" value="${currentcar.id}" ></td>
   <td>${currentcar.make}</td>
   <td>${currentcar.model}</td>
    <td>${currentcar.year}</td>
   </tr>
</c:forEach>
</table>
<br />
<input type = "submit" value = "edit" name="doThisToCar" class="btn btn-warning">
<input type = "submit" value = "delete" name="doThisToCar" class="btn btn-danger">
<input type="submit" value = "add" name = "doThisToCar" class="btn btn-success">

</form>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>

</div>
</body>
</html>