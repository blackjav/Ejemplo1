/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Grafica;
import modelo.UsuarioDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author javs
 */
public class GraficaJFCS extends HttpServlet {

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
        
        
        //TODO aqui
        grafica(request, response);
        /* response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GraficaJFCS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GraficaJFCS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }
    
    
            private void grafica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
                    JFreeChart chart = ChartFactory.createPieChart3D("Alumnos Por Carrera",getGraficaAlumnos(), true, true, Locale.getDefault());
                    String arc = getServletConfig().getServletContext().getRealPath("/grafica2.png");
                    ChartUtilities.saveChartAsPNG(new File(arc), chart, 700, 400);
                    System.out.println("SE RECIBIOa......."+arc);
                    irAPagina("grafica2.jsp", request, response);
        }
            
            private DefaultPieDataset getGraficaAlumnos() {
                    DefaultPieDataset pie = new DefaultPieDataset();
                    UsuarioDAO del = new UsuarioDAO();
                    try {
                        List datos = del.grafica();
                        for (int indice = 0; indice < datos.size(); indice++){
                        Grafica dto = (Grafica)datos.get(indice);
                        pie.setValue(dto.getNombre(), dto.getCantidad());
                    }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
return pie;
}
    private void irAPagina(String graficajsp, HttpServletRequest request, HttpServletResponse response) throws IOException {
       
          response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GraficaJFCS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<img src=\"grafica2.png\"/>");
            out.println("</body>");
            out.println("</html>");
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
