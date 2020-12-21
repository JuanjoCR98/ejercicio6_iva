/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juanjo Cortés
 */
@WebServlet(name = "servletIva", urlPatterns = {"/servletIva"})
public class servletIva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private double iva;
    
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        
        iva = Double.parseDouble(config.getInitParameter("iva"));
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
        PrintWriter out = response.getWriter();
        double precio = Double.parseDouble(request.getParameter("precio"));
        double precioiva= precio * iva;
        double preciototal = precioiva + precio;
        
        out.println("<b>Precio: <b>"+precio+"<br>");
        out.println("<b>Precio IVA: <b>"+precioiva+"<br>");
        out.println("<b>Precio total: <b>"+preciototal+"<br>");
        out.close();
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
