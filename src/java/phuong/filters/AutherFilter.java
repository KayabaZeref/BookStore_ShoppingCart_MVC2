/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phuong.dtos.UserDTO;

/**
 *
 * @author ACER
 */
public class AutherFilter implements Filter {
    
    private final List<String> USER;
    private final List<String> ADMIN;
    private final String LOGIN="login.jsp";
    private final String CUS="CUS";
    private final String AD="AD";
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AutherFilter() {
        USER=new ArrayList<>();
        USER.add("");
        USER.add("login.jsp");        
        USER.add("error.jsp");
        USER.add("MainController");
        USER.add("LoginController");
        USER.add("viewBillPage.jsp");
        USER.add("createUser.jsp");
        USER.add("BuyBookController");
        USER.add("UpdateBookBillController");
        USER.add("DeleteBookBillController");
        USER.add("SearchBookController");
        USER.add("AddController");
        USER.add("LogoutController");

        ADMIN=new ArrayList<>();
        ADMIN.add("");
        ADMIN.add("login.jsp");
        ADMIN.add("insertProduct.jsp");
        ADMIN.add("MainController");
        ADMIN.add("LoginController");
        ADMIN.add("searchProduct.jsp");
        ADMIN.add("ShowInsertPageController");
        ADMIN.add("UpdateProductController");
        ADMIN.add("DeleteProductController");
        ADMIN.add("InsertController");
        ADMIN.add("AdminSearchProductController");
        ADMIN.add("LogoutController");
        
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AutherFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AutherFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenFilter:doFilter()");
        }
       try {
            HttpServletRequest req=(HttpServletRequest) request;
            HttpServletResponse res=(HttpServletResponse) response;
            String uri=req.getRequestURI();
            if(uri.contains(".jpg") || uri.contains(".png") || uri.contains("gif")){
                chain.doFilter(request, response);
            }else{
                if(uri.contains("login.jsp") || uri.contains("MainController") || uri.contains("LoginController") || uri.contains("CreateUserController") 
                        || uri.contains("SearchBookController") || uri.contains("createUser.jsp") || uri.contains("shopping.jsp") || uri.contains("error.jsp")){
                    chain.doFilter(request, response);
                    return;
                }
                int index=uri.lastIndexOf("/");
                String resource=uri.substring(index+1);
                HttpSession session=req.getSession();
                if(session==null || session.getAttribute("LOGIN_USER")==null){
                    res.sendRedirect(LOGIN);
                }else{
                    UserDTO user=(UserDTO) session.getAttribute("LOGIN_USER");
                    String roleID=user.getRoleID().trim();
                    if(AD.equals(roleID) && ADMIN.contains(resource)){
                        chain.doFilter(request, response);
                        
                    }else if(CUS.equals(roleID) && USER.contains(resource)){
                        chain.doFilter(request, response);
                    }else{
                        res.sendRedirect(LOGIN);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("AutherFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AutherFilter()");
        }
        StringBuffer sb = new StringBuffer("AutherFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
