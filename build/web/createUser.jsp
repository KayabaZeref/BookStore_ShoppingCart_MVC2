<%-- 
    Document   : createUser
    Created on : June 22, 2021, 9:12:45 PM
    Author     : ASUS
--%>

<%@page import="phuong.dtos.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <%
            UserErrorDTO errorDTO = (UserErrorDTO) request.getAttribute("USER_ERROR");
            if(errorDTO == null) {
                errorDTO = new UserErrorDTO("", "", "", "", "", "","");
            }
        %>
        <a href="login.jsp">Login</a>
        <div>
            <h1>Create User</h1>
            <form action="MainController" method="POST">
                User ID: <input type="text" name="txtUserID"></br>
                <%=errorDTO.getUserIDError()%></br>

                Full Name: <input type="text" name="txtFullName"></br>
                <%=errorDTO.getFullNameError()%></br>
                
                Address: <input type="text" name="txtAddress"></br>
                <%=errorDTO.getAddressError()%></br>
                
                Phone: <input type="text" name="txtPhone"></br>
                <%=errorDTO.getPhoneError()%></br>

                Role ID: <input type="text" name="txtRoleID" value="CUS" readonly="true"></br>

                Password: <input type="password" name="txtPassword"></br>
                <%=errorDTO.getPasswordError()%></br>

                Confirm: <input type="password" name="txtConfirm"></br>
                <%=errorDTO.getConfirmError()%></br>

                <input type="submit" name="btnAction" value="Create User">
                <input type="reset"  value="Reset">
            </form>
        </div>
    </body>
</html>
