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


<title>Owner List</title>
</head>
<body>
<div class="container">
<h2>Owner List</h2>

<form method = "post" action = "OwnerNavigationServlet" >
<table class="table table-striped table-hover">
<c:forEach items="${requestScope.allOwners}" var="currentOwner">
	<tr>
   		<td><input type="radio" name="id" value="${currentOwner.id}" ></td>
   		<td>${currentOwner.name}</td>
   		<td>${currentOwner.email}</td>
    </tr>
</c:forEach>
</table>
<br />
<input type = "submit" value = "edit" name="doThisToOwner" class="btn btn-warning">
<input type = "submit" value = "delete" name="doThisToOwner" class="btn btn-danger">
<input type="submit" value = "add" name = "doThisToOwner" class="btn btn-success">

</form>
<a href = "index.html"><input type="button" value="Home"></a>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>

</div>
</body>
</html>