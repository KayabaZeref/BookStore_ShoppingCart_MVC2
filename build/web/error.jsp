<%-- 
    Document   : error
    Created on : Apr 17, 2021, 1:28:09 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>This is an Error Page</title>
    </head>
    <body>
        <h1>Error: <%= session.getAttribute("ERROR_MESSAGE") %> </h1>
    </body>
</html>
