/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Note;
import bean.User;
import dao.NoteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ESIC
 */
@WebServlet(name = "ModifierNoteServlet", urlPatterns = {"/modifiernote"})
public class ModifierNoteServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModifierNoteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierNoteServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("memb");
        
        try {
            
            if (u != null) {
                String oldNote = request.getParameter("contenuNote");
                String idNote = request.getParameter("idNote");
                request.setAttribute("oldNote", oldNote);
                request.setAttribute("idNote", idNote);
                request.getRequestDispatcher("/WEB-INF/modifNote.jsp").forward(request, response);
            }
            else {
                request.setAttribute("msg", "Petit malin hein !!!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            
            
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
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
        String comment = request.getParameter("comment");

        int noteId = Integer.parseInt(request.getParameter("idNote"));
        
        HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("memb");

    
        try{
            NoteDao.modifNote(noteId, comment);
            response.sendRedirect("AfficherNotes");
            //request.getRequestDispatcher("AfficherNotes").forward(request, response);
        }catch (Exception e){
            
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
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
