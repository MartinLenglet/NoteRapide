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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table class="table">
            <thead>
                <th>Contenu</th>
                <th>Auteur</th>
                <th>Destinataire</th>
            </thead>
            <tbody>
                <c:forEach items="${ListeMesNotes}" var="n">
                    <tr>
                        <td>${n.contenu}</td>
                        <td>${n.destinataire.infoUser()}</td>
                    </tr>
                </c:forEach>
                <tr></tr>
            </tbody>
        </table>
    </body>
</html>
