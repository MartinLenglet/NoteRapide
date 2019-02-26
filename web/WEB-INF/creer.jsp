<%-- 
    Document   : creer
    Created on : 25 févr. 2019, 16:06:23
    Author     : ESIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Créer une note</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<center>
    <h1>Créer une note</h1>

    <form action="creernote" method="POST">
        <div class="form-group" style="width:40%">
            <label>Commentaire:</label>
            <textarea class="form-control" rows="5" name="comment" method="POST"></textarea>
         </div>
        <input type="submit" class="btn btn-primary btn-block" style="width:40%">

    </form>
</center>
    </body>
</html>
