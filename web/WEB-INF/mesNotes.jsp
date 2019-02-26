<%-- 
    Document   : mesNotes
    Created on : 25 févr. 2019, 16:53:13
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
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
        
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        
        <script src ="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
        
        <script>
             $(document).ready(function() {
                 $('#deuxieme').DataTable();
             } );
        </script>
 
    </head>
    
    <body>
        <h1>Mes Notes :</h1>
        <br>
        
        <div class="container">
        <div class="row">
        <div class="col-9" style="position: absolute; left: 2%; ">
            <table id="deuxieme" class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Contenu</th>
                    <th>Destinataire</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ListeMesNotes}" var="n">
                    <tr>
                        <td>${n.contenu}</td>
                        <td>${n.destinataire.infoUser()}</td>
                        <td><form method="get" action="modifiernote">
                            <input type="hidden" name="idNote" value="${n.id}">
                            <input type="hidden" name="contenuNote" value="${n.contenu}">
                            <button type="submit" class="btn btn-default btn-sm" >
                            <span class="glyphicon glyphicon-pencil"></span> Modifier 
                            </button>
                             </form>
                        </td>
                        <td> <form method="post" action="SupprimerNote">
                            <input type="hidden" name="idNote" value="${n.id}">
                            <button type="submit" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-trash"></span> Supprimer
                            </button>
                             </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        </div>
    </body>
</html>
