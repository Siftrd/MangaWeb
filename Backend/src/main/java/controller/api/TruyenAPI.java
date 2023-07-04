/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.SearchDao;
import dao.TruyenDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Truyen;
import util.JsonConverter;

/**
 *
 * @author suckm
 */
@WebServlet(name = "truyenAPI", urlPatterns = {"/api-truyen"})
public class TruyenAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        Integer amount = null;
        Integer page = null;
        
        try{
            amount = Integer.parseInt(request.getParameter("amount"));
        }catch(NumberFormatException e){
            System.err.println(e);
            amount = 10;
        }
        
        try{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e){
            System.err.println(e);
            page = 1;
        }
                
        String search = request.getParameter("search");
        
        Vector<Truyen> ts = new Vector<>();
        SearchDao sd = new SearchDao();
        ts = sd.getTruyen(amount, page);
        String jsonResponse = gson.toJson(ts);
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonResponse);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        JsonConverter jc = new JsonConverter(request.getReader());
        Truyen t = (Truyen) jc.convertJsonToObject(new Truyen());
        TruyenDao td = new TruyenDao();
        Boolean successful = td.themTruyen(t);
        
        request.getSession().setAttribute("idThemTruyen", t.getId());
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        
        if(successful)
            out.print("{\"mess\": \"Them Truyen Thanh Cong\"}");
        else
            out.print("{\"mess\": \"Them Truyen Khong Thanh Cong\"}");
            
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        JsonConverter jc = new JsonConverter(req.getReader());
        TruyenDao td = new TruyenDao();
        Truyen t = (Truyen) jc.convertJsonToObject(new Truyen());
        Boolean successful = td.suaTruyen(t); 
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        
        if(successful)
            out.print("{\"mess\": \"Sua Truyen Thanh Cong\"}");
        else
            out.print("{\"mess\": \"Sua Truyen Khong Thanh Cong\"}");
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        JsonConverter jc = new JsonConverter(req.getReader());
        JsonObject jo = jc.getJsonObject();
        TruyenDao td = new TruyenDao();
        Boolean successful = td.xoaTruyen(jo.get("id").getAsString()); 
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        
        if(successful)
            out.print("{\"mess\": \"Xoa Truyen Thanh Cong\"}");
        else
            out.print("{\"mess\": \"Xoa Truyen Khong Thanh Cong\"}");
    }
    
    
}
