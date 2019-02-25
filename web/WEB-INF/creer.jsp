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
    <div class="form-group" style="width:40%">
        <label for="comment">Commentaire:</label>
        <textarea class="form-control" rows="5" id="comment"></textarea>
    </div>
    <div class="form-group" style="width:40%">
      <label for="sel1">Choisissez le destinataire:</label>
      <select class="form-control" id="destinataire">
        <option id="1">1 Pierre</option>
        <option id="2">2 Martin</option>
        <option id="3">3 Hugo</option>
        <option id="4">4 Joel</option>
      </select>
    </div>
    <input type="submit" class="btn btn-primary btn-block" style="width:40%">
</center>
    </body>
</html>
