/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.common.hash.Hashing;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author rioxv
 */
@WebServlet(name = "DoiMatKhauController", urlPatterns = {"/doimatkhau"})
public class DoiMatKhauController extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        String username = u.getUserName();
        String oldPass = request.getParameter("oldpass");
        String newPass1 = request.getParameter("newpass1");
        String newPass2 = request.getParameter("newpass2");
        UserDao ud = new UserDao();
        if (!newPass1.equals(newPass2)) {
            request.setAttribute("messP", "Mat khau khong trung nhau");
            request.getRequestDispatcher("/thongtin").forward(request, response);
        } else {
            User check = ud.kiemTraMatkhau(username, encryptPassword(oldPass));
            Boolean tc = ud.doiMatkhau(username, encryptPassword(oldPass), encryptPassword(newPass1));
            if (check == null) {
                request.setAttribute("messP", "Sai mat khau");
                request.getRequestDispatcher("/thongtin").forward(request, response);
            } else {
                request.setAttribute("ss", "1");
                request.setAttribute("messP", "Doi mat khau thanh cong");
                request.getRequestDispatcher("/thongtin").forward(request, response);
            }
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

    private String encryptPassword(String plainPassword) {
        String encryptedPassword = Hashing.sha256()
                .hashString(plainPassword, StandardCharsets.UTF_8)
                .toString();
        return encryptedPassword;
    }
}
