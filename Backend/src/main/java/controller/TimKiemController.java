/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dao.SearchDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Truyen;

/**
 *
 * @author suckm
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class TimKiemController extends HttpServlet {

    String jsonResponse = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ndTimKiem = request.getParameter("search");
        String idTheLoai = request.getParameter("theloai");

        if (ndTimKiem == null && idTheLoai != null) {
            TimVoiIDTheLoai(idTheLoai, request, response);
//            returnJson(request, response);
        } else {
            TimVoiTen(ndTimKiem, request);
            returnJson(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void TimVoiTen(String ndTimKiem, HttpServletRequest request) {
        Gson gson = new Gson();
        Vector<Truyen> ts = new Vector<>();
        SearchDao sd = new SearchDao();
        ts = sd.searchByTen(ndTimKiem);
        
        themTruyenVaoSession(ts, request);
        
        jsonResponse = gson.toJson(ts);

    }

    private void TimVoiIDTheLoaiJson(String ndTimKiem) {
        Gson gson = new Gson();
        Vector<Truyen> ts = new Vector<>();
        SearchDao sd = new SearchDao();
        ts = sd.searchByTheLoai(ndTimKiem);
        jsonResponse = gson.toJson(ts);

    }

    private void TimVoiIDTheLoai(String ndTimKiem, HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        Vector<Truyen> ts = new Vector<>();
        SearchDao sd = new SearchDao();
        ts = sd.searchByTheLoai(ndTimKiem);
        request.getSession().setAttribute("dsTruyen", ts);
        try {
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (IOException ex) {
            Logger.getLogger(TimKiemController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void returnJson(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(TimKiemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonResponse);
        out.flush();
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
}
