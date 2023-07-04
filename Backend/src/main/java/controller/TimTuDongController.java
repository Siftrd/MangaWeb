/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SearchDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Truyen;

/**
 *
 * @author Hung Dinh
 */
@WebServlet(name = "TimTuDongController", urlPatterns = {"/searchAuto"})
public class TimTuDongController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        SearchDao dao = new SearchDao();
        Vector<Truyen> list = dao.searchByTen(txtSearch);
        themTruyenVaoSession(list, request);
        PrintWriter out = response.getWriter();

        for (Truyen t : list) {
            out.println("<a class='truyen' href=\"read?truyenID=" + t.getId() + "\">\n"
                    + "                    <div style=\"width: 85%; height: 80%; justify-content: center\">\n"
                    + "                        <img style=\"width: calc(100%*3/4); height: 100%; border-radius: 5px \" src=\"img/Thumbnails/" + t.getId() + ".jpg\" alt=\"" + t.getId() +"\"/>\n"
                    + "                        <!--<img style=\"width: calc(100%*3/4); height: 100%; border-radius: 5px \" src=\"img/Thumbnails/DRM1.jpg\" alt=\"${t.id}\"/>-->\n"
                    + "                    </div>\n"
                    + "                    <p style=\"color: white;font-size: 30px;text-decoration: none;display: flex;width: 100%; height:15%;justify-content: center\">\n"
                    + "                        " + t.getTen() + "\n"
                    + "                    </p>\n"
                    + "                </a>");
        }
    }
    
    private void themTruyenVaoSession(Vector<Truyen> ts, HttpServletRequest request){
        Hashtable<String, Truyen> truyenHM = (Hashtable) request.getSession().getAttribute("truyenHM");
        
        for(Truyen t : ts){
            if(!truyenHM.containsKey(t.getId())){
                truyenHM.put(t.getId(), t);
            }
        }
        request.getSession().setAttribute("truyenHM", truyenHM);
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
