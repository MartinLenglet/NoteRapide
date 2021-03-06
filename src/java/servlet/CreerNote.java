/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import bean.Note;
import bean.User;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dao.UserDao;
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
@WebServlet(name = "CreerNoteServlet", urlPatterns = {"/creernote"})
public class CreerNote extends HttpServlet {

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
            out.println("<title>Servlet CreerNote</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreerNoteServlet at " + request.getContextPath() + "</h1>");
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
        
          try{
              
         List<User> membres = UserDao.getAllMember();
            request.setAttribute("utilisateur",membres);
            request.getRequestDispatcher("/WEB-INF/creer.jsp").forward(request, response);
          }
          catch(Exception e){
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

    
        Note note = new Note ();
        
        HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("memb");

  
        //note.setDestinataire(d);
       
        String d = request.getParameter("dest");
        int dest_id = Integer.parseInt(d);
        User dest = new User();

        if(dest_id==0){
            dest.setPrenom("Note");
            dest.setNom("Publique");
            note.setDestinataire(dest);
        }else{
        dest.setId(dest_id);
        note.setDestinataire(dest);
        }
        note.setAuteur(u);
        note.setContenu(comment);
        
        
        try{

            NoteDao.insert(note);
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
