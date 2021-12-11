<%-- 
    Document   : shopping
    Created on : June 22, 2021, 9:12:45 PM
    Author     : ASUS
--%>

<%@page import="phuong.dtos.ProductDTO"%>
<%@page import="phuong.dtos.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="phuong.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>

        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

            List<CategoryDTO> listCate = (List<CategoryDTO>) request.getAttribute("LIST_CATE");
        %>

        <%
            if (user != null) {
        %>

        <h3>Customer Name : <%=user.getFullName()%></h3>
        <a href="MainController?btnAction=View">View</a></br>
        <%
        } else {
        %>
        <a href="login.jsp">Login</a></br>
        <%
            }

        %>
        <form action="MainController" method="POST">
            Book Name: <input type="text" name="txtBookName" value="<%= request.getParameter("txtBookName") == null ? "" : request.getParameter("txtBookName")%>">
            Select your category: 
            <select name="cmbCate">
                <%
                    if (listCate != null) {
                        for (CategoryDTO dto : listCate) {
                %>
                <option value="<%=dto.getCategoryID()%>"> <%= dto.getCategoryName()%> </option>
                <%
                    }
                %>
                <option value=""> ALL BOOK </option>
                <%
                    }

                %>
            </select>
            <input type="submit" name="btnAction" value="SearchBook">

        </form>

        <%                
            String message = (String) request.getAttribute("MESSAGE");
            if (message != null) {
        %>
        <h3>
            <%= message%>
        </h3>
        <%
            }
        %>
        <div>
            <%
                List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
                if (list != null) {

            %>
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Category ID</th>
                    </tr>
                </thead>
                <tbody>
                    <%                        
                        int count = 0;
                        for (ProductDTO dto : list) {
                    %>
                <form action="MainController" method="POST">
                    <tr>
                        <td><%= ++count%></td>
                        <td><%= dto.getProductID()%></td>
                        <td><%= dto.getProductName()%></td>
                        <td><%= dto.getDescription()%></td>
                        <td><%= dto.getPrice()%></td>
                        <td>
                            <input type="number" name="txtQuantity" value="1" min="1" max="<%= dto.getQuantity()%>" step="1"/>
                        </td>
                        <td><%= dto.getCategoryID()%></td>
                    <input type="hidden" name="txtProductID" value="<%= dto.getProductID()%>"/>
                    <input type="hidden" name="txtProductName" value="<%= dto.getProductName()%>"/>
                    <input type="hidden" name="txtPrice" value="<%= dto.getPrice()%>"/>
                    <input type="hidden" name="txtCatagoryID" value="<%= dto.getCategoryID()%>"/>
                    <%
                        if (user != null) {
                    %>
                    <td>
                        <input type="submit" name="btnAction" value="Add"/>
                    </td>
                    <%
                        }
                    %>
                    <input type="hidden" name="txtBookName" value="<%= request.getParameter("txtBookName") == null ? "" : request.getParameter("txtBookName")%>">
                    <input type="hidden" name="cmbCate" value="<%= request.getParameter("cmbCate") == null ? "" : request.getParameter("cmbCate")%>">
                    </tr>
                </form>
                <%
                    }
                %>
                </tbody>
            </table>
            <%
                }
            %>
        </div>
    </body>
    <footer>
        <%
            if (user != null) {
        %>
        <a href="MainController?btnAction=Logout">Logout</a>
        <%
        } %>
    </footer>
</html>
