<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >

<title>Add Owners to Owners List</title>
</head>
<body>
<div class="container">
<h2>Add an Owner to  Ownerslist</h2>

<form action = "<%= request.getContextPath() %>/  	addOwnerServlet" method="post">
<div class="form-group">
<label for="name">Name:</label><input type ="text" name = "name"><br />
</div>

<div class="form-group">
<label for="email">Email:</label>
<input type = "text" name = "model"><br />
</div>



<input type="submit" value="Add Owner">
</form>
<br />

<a href = "/ViewAllOwnersServlet">View the complete List</a>
<br />
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 
</body>
</html>