/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.common.hash.Hashing;
import controller.api.YeuThichAPI;
import dao.UserDao;
import dao.YeuThichDao;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suckm
 */
@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class DangKyController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ho = request.getParameter("Ho");
        String ten = request.getParameter("Ten");
        String username = request.getParameter("Username");
        String pass = request.getParameter("password");
        
        UserDao ud = new UserDao();
        Boolean successfull = ud.signup(ho, ten, encryptPassword(pass), username);
        if(successfull){
            response.sendRedirect("home");
            new YeuThichDao().addNewDanhSachYeuThichById(username);
        }
        else{
            request.setAttribute("mess", "Lam on nhap lai");
            request.getRequestDispatcher("dangky").forward(request, response);
        }
    }
    
    private String encryptPassword(String plainPassword){
        String encryptedPassword = Hashing.sha256()
                            .hashString(plainPassword, StandardCharsets.UTF_8)
                            .toString();
        return encryptedPassword;
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
