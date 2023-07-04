/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.SearchDao;
import dao.TruyenDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Truyen;
import model.User;
import util.JsonConverter;

/**
 *
 * @author suckm
 */
@WebServlet(name = "NguoiDungAPI", urlPatterns = {"/nguoidung"})
public class NguoiDungAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        Vector<User> ts = new Vector<>();
        UserDao ud = new UserDao();
        ts = ud.dsNguoiDung();
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
        
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        JsonConverter jc = new JsonConverter(req.getReader());
        JsonObject jo = jc.getJsonObject();
        UserDao td = new UserDao();
        
        String userName = jo.get("userName").getAsString();
        String firstName = jo.get("firstName").getAsString();
        String lastName = jo.get("lastName").getAsString();
        
        Boolean successful = td.suaNguoiDung(userName, firstName, lastName); 
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        
        if(successful)
            out.print("{\"mess\": \"Sua Thong Tin Nguoi Dung Thanh Cong\"}");
        else
            out.print("{\"mess\": \"Sua Thong Tin Nguoi Dung Khong Thanh Cong\"}");
    }
    
    

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        JsonConverter jc = new JsonConverter(req.getReader());
        JsonObject jo = jc.getJsonObject();
        UserDao td = new UserDao();
        Boolean successful = td.xoaNguoiDung(jo.get("userName").getAsString()); 
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        
        if(successful)
            out.print("{\"mess\": \"Xoa Nguoi Dung Thanh Cong\"}");
        else
            out.print("{\"mess\": \"Xoa Nguoi Dung Khong Thanh Cong\"}");
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
