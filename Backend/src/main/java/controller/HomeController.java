/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SearchDao;
import dao.TruyenDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TheLoai;
import model.Truyen;

/**
 *
 * @author suckm
 */
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        getData(request, response);
        goToIndex(request, response);
    }
    
    private void getData(HttpServletRequest request, HttpServletResponse response){
        Integer page = null;
        Integer amount = 0;
        Vector<Truyen> ts = new Vector<>();
        Vector<TheLoai> tls = new Vector<>();
        
        Hashtable<String, Truyen> truyenHM = (Hashtable<String, Truyen>) request.getSession().getAttribute("truyenHM");
        
        if(truyenHM == null){
            truyenHM = new Hashtable<>();
        }

        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1;
        }

        TruyenDao td = new TruyenDao();
        ts = td.getTruyen(10, page);
        tls = td.getTheLoai();
        amount = (int) Math.ceil(td.countTruyen() / 10);
        
        for(Truyen t : ts){
            if(!truyenHM.containsKey(t.getId())){
                truyenHM.put(t.getId(), t);
            }
        }
        
        request.getSession().setAttribute("dsTruyen", ts);
        request.getSession().setAttribute("dsTheLoai", tls);
        request.getSession().setAttribute("truyenHM", truyenHM);
        request.getSession().setAttribute("amount", amount);
        
        
    }
    
    private void goToIndex(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/index").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
