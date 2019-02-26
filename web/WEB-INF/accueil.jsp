<%-- 
    Document   : accueil
    Created on : 25 févr. 2019, 15:39:24
    Author     : ESIC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Page quand on se connecte</h1>
        <br><br>
        <div class="container">

        <div class="row">
        <div class="col-9" style="position: absolute; left: 2%; ">
            <table class="table table-bordered table-hover">
            <thead>
                <th>Contenu</th>
                <th>Auteur</th>
                <th>Destinataire</th>
            </thead>
            <tbody>
                <c:forEach items="${ListeNotes}" var="n">
                    <tr>
                        <td>${n.contenu}</td>
                        <td>${n.auteur.infoUser()}</td>
                        <td>${n.destinataire.infoUser()}</td>
                        <td><button type="button" class="btn btn-default btn-sm">                               
                                <span class="glyphicon glyphicon-pencil"></span> Modifier
                             </button>
                        </td>
                        <td><button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-trash"></span> Supprimer 
                           </button>
                        </td>

                    </tr>

                </c:forEach>
                    
                <tr></tr>
            </tbody>
        </table> 
        </div>
        </div>
    </div>
    </body>
</html>
