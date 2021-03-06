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
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Mail;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author javs
 */
public class Controler extends HttpServlet {

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
            throws ServletException, IOException, SQLException, MessagingException {
        //Declaracion de variabes
        Usuario u = new Usuario();
        UsuarioDAO c = new UsuarioDAO();
        Mail mail = new Mail();
        List lista;
        String nombre,paterno,materno,email,nombreUser,claveUser,tipoUser,enlace;
        int id;
        
        //induccion a clase usuario
        u.setNombre(request.getParameter("txtNombre"));
        u.setaPaterno(request.getParameter("txtPaterno"));
        u.setaMaterno(request.getParameter("txtMaterno"));
        u.setEmail(request.getParameter("txtMail"));
        u.setUsuario(request.getParameter("txtUsuario"));
        u.setClave(request.getParameter("txtPass"));
        u.setTipoUsuario(request.getParameter("txtTipo"));
       
        c.create(u);
        mail.enviarMail(u.getEmail(), "Registro Exitoso", "Bienvenido usted se ha registrado exitosamente");
        
        response.sendRedirect("VerListS");
        
        //int id;
       
        
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
            throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (SQLException ex ) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
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
