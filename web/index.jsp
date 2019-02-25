<%-- 
    Document   : index
    Created on : 25 févr. 2019, 09:52:14
    Author     : ESIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </head>
    <body>
        <br> <br>
        <h1 style="text-align: center; margin-top: 2%;"> Connexion</h1>
        
        <div style="margin: auto; width: 40%; margin-top: 2%;">
        <form method="post" action="Connexion">
            <div class="form-group">
                <input type="text" class="form-control" name="login" placeholder="Login">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="mdp" placeholder="Mot de passe">
            </div>
            <input type="submit" class="btn-primary btn-block">
        </form>
            <p></p>
            <p style="color: tomato;">${msg}</p>
            <a href="inscription">Inscrivez vous</a>
        </div>

    </body>
</html>
