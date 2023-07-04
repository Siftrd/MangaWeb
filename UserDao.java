/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.DatabaseHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author suckm
 */
public class UserDao {
    private Connection conn = null;
    private ResultSet rs = null;
    public UserDao() {
//        DatabaseHelper dbc = new DatabaseHelper();
        DatabaseHelper dbc = DatabaseHelper.getSingletonInstance();
        conn = dbc.getConn();
    }
    
    public User login(String user, String pass){
        String sql = "select * from [dbo].[user] where username = ? and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getString(1),rs.getString(2),rs.getString(5), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println("No result for user found");
        }
        
        return null;
    }
    public User kiemTraMatkhau(String username, String hashedPass){
        String sql = "select * from [dbo].[user] where userName = ? and password = ?";
        if(username.equals("")) return null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hashedPass);
            ps.setString(2, username);
            ps.execute();
            while(rs.next()){
                return new User(rs.getString(1),rs.getString(2),rs.getString(5),rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return null;
    }
     public Boolean doiMatkhau(String username, String hashedPass1,String hashedPass2){
        String sql = "update [dbo].[user] set password = ? where userName = ? and password = ?";
        if(username.equals("")) return null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hashedPass2);
            ps.setString(2, username);
            ps.setString(3, hashedPass1);
            ps.execute();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public Boolean signup(String Ho, String Ten, String hashedPassword, String username){
        String sql = "INSERT INTO [dbo].[user]([firstName],[lastName],[password],[username])VALUES(?, ?, ?, ?)";
        if(username.equals("")) return null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Ten);
            ps.setString(2, Ho);
            ps.setString(3, hashedPassword);
            ps.setString(4, username);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("No result for user found");
        }
        
        return false;
    }
    
    public Boolean xoaNguoiDung(String username){
        String sql = "Delete from [dbo].[user] where userName = ?";
        if(username.equals("")) return null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Xoa Nguoi Dung That Bai");
        }
        
        return false;
    }
    
    public Boolean suaNguoiDung(String username, String firstName, String lastName,String email){
        String sql = "update [dbo].[user] set firstName = ?, lastName = ?,email = ? where userName = ?";
        if(username.equals("")) return null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Sua Nguoi Dung That Bai");
        }
        
        return false;
    }
    
    public Vector<User> dsNguoiDung(){
        Vector<User> ds = new Vector<>();
        
        String sql = "SELECT firstName,lastName,username\n" +
                    "FROM dbo.[user]";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ds.add(new User(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("No result for user found");
        }
        
        return ds;
    }

}
