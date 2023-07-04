/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.api;

import com.google.gson.JsonObject;
import dao.YeuThichDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Truyen;
import org.json.*;
import util.JsonConverter;

/**
 *
 * @author suckm
 */
@WebServlet(name = "yeuThichAPI", urlPatterns = {"/api-fav"})
public class YeuThichAPI extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        YeuThichDao ytd = new YeuThichDao();
        
        String username = null;
        
        try{
            username = request.getParameter("name");
        }
        catch(NullPointerException e){
            username = "";
        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(ytd.getYeuThichById(username));
        out.flush();
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        YeuThichDao ytd = new YeuThichDao();
        JsonConverter jc = new JsonConverter(req.getReader());
        JSONObject obj = new JSONObject(jc.getJsonString());
        String userName = obj.getString("name");
        
        ytd.addNewDanhSachYeuThichById(userName);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        YeuThichDao ytd = new YeuThichDao();
        JsonConverter jc = new JsonConverter(req.getReader());
        JSONObject obj = new JSONObject(jc.getJsonString());
        
        String userName = obj.getString("name");
        JSONObject truyenObj = obj.getJSONObject("truyen");
        Truyen t = new Truyen(truyenObj.getString("id"), truyenObj.getString("ten"), truyenObj.getString("nxb"));
        
        ytd.addYeuThichById(userName, t);
        
        System.out.println(userName);
        System.out.println(truyenObj.getString("id"));
        
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        out.print("{\"mess\": \"Them Truyen Thanh Cong\"}");
        
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
