<%-- 
    Document   : creer
    Created on : 25 févr. 2019, 16:06:23
    Author     : ESIC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="menu.jsp" %>
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
            <label>Note:</label>
            <textarea class="form-control" rows="5" name="comment"></textarea>
         </div>
        <br>
<div class="container">
    <div class="form-group" style="width:40%">
      <label for="dest">Destinataire:</label>
      

    </div>
</div>
        
                  <select class="form-control" id="dest-select" name="dest" style="width:40%">
          
<c:forEach items="${utilisateur}" var="u">
    <option value="${u.id}">${u.nom} ${u.prenom}
            
            </option>
</c:forEach>
            <option></option>

        
      </select>
 
      <br>
        <input type="submit" class="btn btn-primary btn-block" style="width:40%">

    </form>
    

</center>
    </body>
</html>
