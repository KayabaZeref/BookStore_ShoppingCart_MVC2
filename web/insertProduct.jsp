<%-- 
    Document   : insertProduct
    Created on : June 22, 2021, 9:12:45 PM
    Author     : ASUS
--%>

<%@page import="phuong.dtos.ProductErrorDTO"%>
<%@page import="phuong.dtos.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <%
            List<CategoryDTO> listCate = (List<CategoryDTO>) request.getAttribute("LIST_CATE");
            ProductErrorDTO errorDTO = (ProductErrorDTO) request.getAttribute("PRODUCT_ERROR");
            if (errorDTO == null) {
                errorDTO = new ProductErrorDTO("", "", "", "", "", "");
            }
        %>
        <form action="MainController" method="POST">
            Product ID: <input type="text" name="txtProductID"></br>
            <%= errorDTO.getProductIDError()%></br>
            Product Name: <input type="text" name="txtProductName"></br>
            <%= errorDTO.getProductNameError()%></br>
            Product Description: <input type="text" name="txtDescription"></br>
            <%= errorDTO.getProcductDescriptionError()%></br>
            Product Price: <input type="number" name="txtPrice"></br>
            <%= errorDTO.getPriceError()%></br>
            Product Quantity: <input type="number" name="txtQuantity"></br>
            <%= errorDTO.getQuantityError()%></br>
            Category ID: <select name="cmbCate">
                <%
                    if (listCate != null) {
                        for (CategoryDTO dto : listCate) {
                %>
                <option value="<%=dto.getCategoryID()%>"> <%= dto.getCategoryName()%> </option>
                <%
                        }
                    }
                %>
            </select></br>
            <input type="submit" name="btnAction" value="InsertProduct">
            <input type="reset"  value="Reset">
            
        </form>
    </body>
</html>
