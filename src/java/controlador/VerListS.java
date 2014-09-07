/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author javs
 */
public class VerListS extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        
        
        
        Usuario u = new Usuario();
        UsuarioDAO c = new UsuarioDAO();
        List lista;
        String nombre,paterno,materno,email,nombreUser,claveUser,tipoUser,enlace,enlaceU;
        String enlaceG;
        int id;
        String pagina;
        List ls;
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            pagina="<!DOCTYPE html>";
            pagina +="<html>";
            pagina +="<head>";
            pagina +="<title>userlist</title>";            
            pagina +="</head>";
            pagina +="<body>";
            pagina +="<h1>Lista de usuarios" + request.getContextPath() + "</h1>";
            pagina +="<table>";
            ls = c.loadAll();
            for(int i = 0; i<ls.size();i++){
                Usuario lu= (Usuario)(ls.get(i));
                
                id = lu.getId();
                //System.out.println(id+" "+ls.size());
                nombre = lu.getNombre();
                paterno =lu.getaPaterno();
                materno = lu.getaMaterno();
                email = lu.getEmail();
                nombreUser = lu.getUsuario();
                claveUser = lu.getClave();
                tipoUser = lu.getTipoUsuario();
                
                enlace = "<a href='DeletS?id="+id+"'>"+"borrar"+"</a>";
                enlaceU = "<a href='UpdateS?id="+id+"'>"+"Actualiar"+"</a>";
                
                
                pagina += "<tr>";
                pagina += "<td>" +id+"</td>";
                
                System.err.println(id);
                pagina += "<td>" +nombre+"</td>";
                pagina += "<td>" +paterno+"</td>";
                pagina += "<td>" +materno+"</td>";
                pagina += "<td>" +email+"</td>";
                pagina += "<td>" +nombreUser+"</td>";
                pagina += "<td>" +claveUser+"</td>";
                pagina += "<td>" +tipoUser+"</td>";
                pagina += "<td>" +enlace+"</td>";
                pagina += "<td>" +enlaceU+"</td>";
               pagina += "</tr>";
                
            }
            enlaceG = "<a href='GraficaJFCS'>"+"Ver Grafica"+"</a>";
            pagina +="<table>";
            pagina += enlaceG;
            pagina +="</body>";
            pagina +="</html>";
            
            out.println(pagina);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VerListS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VerListS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
