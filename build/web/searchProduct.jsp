<%-- 
    Document   : searchProduct
    Created on : Apr 18, 2021, 12:43:41 AM
    Author     : ACER
--%>

<%@page import="java.util.List"%>
<%@page import="phuong.dtos.ProductDTO"%>
<%@page import="phuong.dtos.ProductDTO"%>
<%@page import="phuong.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        %>
       
        <h1>Hello All Powerful : <%= user.getFullName()%></h1>
         <a href="MainController?btnAction=Insert Page">Insert New Book</a></br>
        
        <%
            String searchValue = request.getParameter("name");
            if (searchValue == null) {
                searchValue = "";
            }
        %>
        <form action="MainController">
            </br>Search Name: <input type="text" name="txtSearchName" value="<%= searchValue%>">
            Search by Category: <input type="text" name="txtSearchType" value="<%= searchValue%>">
            <input type="submit" name="btnAction" value="Search Book"/>
        </form>
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
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Category ID</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO dto : list) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td><input type ="text" name="txtProductID" value="<%= dto.getProductID()%>" readonly="true"</td>
                    <td>
                        <input type ="text" name="txtProductName" value="<%= dto.getProductName()%>"/>
                    </td>
                    <td>
                        <input type ="text" name="txtDescription" value="<%= dto.getDescription() %>"/>
                    </td>
                    <td>
                        <img src="<%= request.getContextPath() %>/picture/<%= dto.getImage()%>" height="100" width="100"/>
                    </td>
                    <td>
                        <input type ="number" name="txtPrice" value="<%= dto.getPrice()%>"/>
                    </td>
                    <td>
                        <input type ="number" name="txtQuantity" value="<%= dto.getQuantity()%>"/>
                    </td>
                    <td>
                        <input type ="text" name="txtCategoryID" value="<%= dto.getCategoryID()%>"/>
                    </td>
                    <td>
                        <a href="MainController?btnAction=Delete&txtProductID=<%= dto.getProductID()%>&txtSearchName=<%= searchValue%>&txtSearchType=<%= searchValue%>">Delete Book</a>
                    </td>
                    <td>
                        <input type="submit" name="btnAction" value="Update"/>
                        <input type="hidden" name="txtSearchName" value="<%=request.getParameter("txtSearchName")%>"/>
                        <input type="hidden" name="txtSearchType" value="<%=request.getParameter("txtSearchType")%>"/>
                    </td>
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
</body>
<footer>
    </br><a href="MainController?btnAction=Logout">Logout</a></br>
</footer>
</html>
