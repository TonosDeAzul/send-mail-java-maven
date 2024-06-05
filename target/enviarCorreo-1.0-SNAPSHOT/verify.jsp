<%-- 
    Document   : verify
    Created on : 5/06/2024, 4:57:59 p. m.
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="VerifyCode" method="post">
            <label>Ingrese el código:</label>
            <input type="text" name="authcode">
            <input type="submit" value="Send">            
        </form>
    </body>
</html>
