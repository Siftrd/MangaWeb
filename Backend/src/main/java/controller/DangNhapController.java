/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.common.hash.Hashing;
import dao.UserDao;
import java.io.IOException;
import java.net.HttpCookie;
import java.nio.charset.StandardCharsets;
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
 * @author suckm
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class DangNhapController extends HttpServlet {
    
    final int ADMIN = 1;
    final int USER = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("password");
        UserDao ud = new UserDao();
        User u = ud.login(user, encryptPassword(pass));
        if(u == null){
            request.setAttribute("mess", "Tài khoản không tồn tại");
            request.getRequestDispatcher("/dangnhap").forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            
            Cookie cookie = new Cookie("user",u.getUserName());
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    private String encryptPassword(String plainPassword){
        String encryptedPassword = Hashing.sha256()
                            .hashString(plainPassword, StandardCharsets.UTF_8)
                            .toString();
        return encryptedPassword;
    }

}
