<%-- 
    Document   : login
    Created on : June 22, 2021, 9:12:45 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Welcome to Wonder of Knowledge, please Login.</h1>
        <form action="MainController" method="POST">
            User ID:<input type="text" name="txtUserID"/></br>
            Password: <input type="password" name="txtPassword"/></br>
            <input type="submit" name="btnAction" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <a href="MainController?btnAction=Create Page">Create User</a></br>
        <a href="MainController?btnAction=SearchBook">Shopping Page</a></br>
    </body>
</html>
