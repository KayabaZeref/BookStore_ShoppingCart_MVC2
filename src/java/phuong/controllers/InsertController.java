/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuong.daos.ProductDAO;
import phuong.dtos.ProductDTO;
import phuong.dtos.ProductErrorDTO;

/**
 *
 * @author admin
 */
public class InsertController extends HttpServlet {

    private final static String ERROR   = "ShowInsertPageController";
    private final static String SUCCESS = "searchProduct.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        ProductErrorDTO errorObject = new ProductErrorDTO("", "", "", "", "", "");
        try {
            String productID = request.getParameter("txtProductID");
            String productName = request.getParameter("txtProductName");
            String price = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
            String categoryID = request.getParameter("cmbCate");
            String statusID = request.getParameter("txtStatusID");
            String description = request.getParameter("txtDescription");
            String image = request.getParameter("txtImage");

            ProductDAO pdao = new ProductDAO();
            boolean check = true;
            
            if (productID.isEmpty()) {
                check = false;
                errorObject.setProductIDError("Product ID is wrong format !");
            }
            if (productName.isEmpty()) {
                check = false;
                errorObject.setProductNameError("FullName can not be empty !");
            }
            
            if (description.isEmpty()) {
                check = false;
                errorObject.setProductNameError("Description can not be empty !");
            }
            
            if (price.isEmpty()) {
                try {
                    float priceF = Float.parseFloat(price);
                } catch (NumberFormatException e) {
                    check = false;
                    errorObject.setPriceError("Price cannot found !");
                }
            }
            if (quantity.isEmpty()) {
                try {
                    int quantityI = Integer.parseInt(quantity);
                } catch (NumberFormatException e) {
                    check = false;
                    errorObject.setQuantityError("Quantity not found");
                }
            }
            if (pdao.checkProductID(productID) == true) {
                check = false;
                errorObject.setProductIDError("Product ID is duplicate !");
            }
            if (check == true) {
                ProductDTO product = new ProductDTO(productID, productName, Float.parseFloat(price), Integer.parseInt(quantity), categoryID, statusID, description, image);
                pdao.insert(product);
                url = SUCCESS;
            } else {
                request.setAttribute("PRODUCT_ERROR", errorObject);
            }

        } catch (Exception e) {
            log("Error at InsertServlet: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
