<%-- 
    Document   : viewBillPage
    Created on : June 22, 2021, 9:12:45 PM
    Author     : ASUS
--%>

<%@page import="java.util.Set"%>
<%@page import="phuong.dtos.CartDTO"%>
<%@page import="phuong.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null ) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        
                <h1>Your Bill </h1>
                <%
                UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                float totalMoney = 0;
                if (cart == null){
                %> 
                <h2> Opps !! There is nothing here, how about go back and buy something </h2>
                <%
                }
                if (cart != null) {
                    int no = 1;  
                %>
                    <h3>Name : <%=user.getFullName()%></h3>
                    <h3>Address : <%=user.getAddress()%></h3>
                    <h3>Phone : <%=user.getPhone() %></h3>
                    <br>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Book</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Category</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  
                                Set<String> key=cart.getCart().keySet();
                                for (String string : key) {
                                    totalMoney += cart.getCart().get(string).getPrice() * cart.getCart().get(string).getQuantity();
                            %>
                                    <form action="MainController">
                                        <tr>
                                            <td><%= no++%></td>
                                            <td><%= cart.getCart().get(string).getProductName()%></td>
                                            <td><%= cart.getCart().get(string).getPrice()%></td>
                                            <td>
                                                <input type="number" name="txtQuantity" value="<%= cart.getCart().get(string).getQuantity()%>"
                                            </td>
                                            <td><%= cart.getCart().get(string).getCategoryID()%></td>
                                            <td>                       
                                                <input type="submit" name="btnAction" value="Update Book"/>
                                                <input type="hidden" name="txtProductID" value="<%= cart.getCart().get(string).getProductID()%>"/>
                                            </td>
                                            <td>                       
                                                <input type="submit" name="btnAction" value="Delete Book"/>
                                                <input type="hidden" name="txtProductID" value="<%= cart.getCart().get(string).getProductID()%>"/>
                                            </td>
                                        </tr>
                                    </form>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
         
                    <h2>Total: <%=totalMoney%></h2>
                    
                    <form action="MainController" >
                        Your email to see Order status: <input type="text" name="txtEmail"/></br>
                        <input type="submit" name="btnAction" value="Buy Book"/>
                        <input type="hidden" name="txtUserID" value="<%=user.getUserID()%>"/>    
                        <input type="hidden" name="totalMoney" value="<%=totalMoney%>"/>  
                    </form>
                <%
                }
                %>

                <% String messageBuy = (String) request.getAttribute("MESSAGE_BUY");
                    if (messageBuy != null) {
                %>   
                        <h3><%=messageBuy%></h3>
                <%  }
                %>
                <a href="SearchBookController" class="add">Add more Book !</a> 

                <% String messageErrorBuy = (String) request.getAttribute("MESSAGE_BUY_ERROR");
                    if (messageErrorBuy != null) {
                %>   
                        <h3><%=messageErrorBuy%></h3>
                <%  }
                %>
   </body>
</html>
