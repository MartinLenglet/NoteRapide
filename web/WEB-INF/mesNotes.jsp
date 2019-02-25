<%-- 
    Document   : mesNotes
    Created on : 25 févr. 2019, 16:53:13
    Author     : ESIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
