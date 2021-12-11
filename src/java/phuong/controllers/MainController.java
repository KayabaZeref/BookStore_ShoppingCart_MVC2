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

/**
 *
 * @author admin
 */
public class MainController extends HttpServlet {

    private static final String ERROR           = "error.jsp";
    private static final String LOGIN           = "LoginController";
    private static final String LOGOUT          = "LogoutController";
    private static final String CREATE_USER     = "CreateUserController";
    private static final String CREATE_PAGE     = "createUser.jsp";
    private static final String SEARCH_BOOK     = "SearchBookController";
    private static final String ADD             = "AddController";
    private static final String VIEW            = "viewBillPage.jsp";
    private static final String UPDATE_BILL     = "UpdateBookBillController";
    private static final String DELETE_BILL     = "DeleteBookBillController";
    private static final String BUY_BOOK        = "BuyBookController";
    private static final String SEARCH_PRODUCT  = "AdminSearchProductController";
    private static final String UPDATE_PRODUCT  = "UpdateProductController";
    private static final String DELETE_PRODUCT  = "DeleteProductController";
    private static final String INSERT_PRODUCT  = "InsertController";
    private static final String INSERT_PAGE     = "ShowInsertPageController";
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
        
        try {
            String action = request.getParameter("btnAction");
            if("Login".equals(action)){
                url =LOGIN;
            }else if("Logout".equals(action)){
                url =LOGOUT;
            }else if("Create User".equals(action)){
                url =CREATE_USER;
            }else if("Create Page".equals(action)){
                url =CREATE_PAGE;
            }else if("SearchBook".equals(action)){
                url =SEARCH_BOOK;
            }else if("Add".equals(action)){
                url =ADD;
            }else if("View".equals(action)){
                url =VIEW;
            }else if("Update Book".equals(action)){
                url =UPDATE_BILL;
            }else if("Delete Book".equals(action)){
                url =DELETE_BILL;
            }else if("Buy Book".equals(action)){
                url =BUY_BOOK;
            }else if("Search Book".equals(action)){
                url =SEARCH_PRODUCT;
            }else if("Update".equals(action)){
                url =UPDATE_PRODUCT;
            }else if("Delete".equals(action)){
                url =DELETE_PRODUCT;
            }else if("InsertProduct".equals(action)){
                url =INSERT_PRODUCT;
            }else if("Insert Page".equals(action)){
                url =INSERT_PAGE;
            }
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
        }finally{
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
