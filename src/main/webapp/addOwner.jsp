<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >

<title>Add Owner</title>
</head>
<body>
<div class="container">
<h2>Add an Owner to  Ownerslist</h2>

<form action = "AddOwnerServlet" method="post">
<div class="form-group">
<label for="name">Name:</label>
<input type ="text" name = "name" required><br />
</div>

<div class="form-group">
<label for="email">Email:</label>
<input type = "text" name = "email" required><br />
</div>



<input type="submit" value="Add Owner">
</form>
<br />

<a href = "ViewAllOwnersServlet"><input type="button" value="View the complete List"></a>
<a href = "index.html"><input type="button" value="Home"></a>

<br />
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 
</body>
</html>