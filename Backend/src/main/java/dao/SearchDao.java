/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.DocTruyenController;
import util.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Truyen;

/**
 *
 * @author suckm
 */
public class SearchDao {
    Connection con = null;
    public SearchDao() {
        DatabaseHelper dbh = DatabaseHelper.getSingletonInstance();
        con = dbh.getConn();
    }
    
    public Vector<Truyen> searchByTen(String nd){
        String content = nd.trim();
        
        String query = "select * from truyen where ten like ?";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + content + "%");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ko co result set");
        }
        
        
        Vector<Truyen> ts = new Vector<>();
        try {
            while(rs.next()){
                Truyen t = new Truyen(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getInt(4));
                ts.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ts;
    }
    
    public Vector<Truyen> searchByTheLoai(String idTheLoai){
        String content = idTheLoai.trim();
        
        String query = "select * from truyen where idTheLoai = ?";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, idTheLoai);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ko co result set");
        }
        
        
        Vector<Truyen> ts = new Vector<>();
        try {
            while(rs.next()){
                Truyen t = new Truyen(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getInt(4));
                ts.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ts;
    }
    
    public Vector<Truyen> getTruyen(int soLuong, int page){
        String query = "select * from dbo.truyen where stt > ? and stt <= ?";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 10*(page-1));
            ps.setInt(2, 10*page);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ko co truyen");
        }
        
        
        Vector<Truyen> ts = new Vector<>();
        try {
            while(rs.next()){
                Truyen t = new Truyen(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ts.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ts;
    }
    
    public Integer countTruyen(){
        String query = "select max(stt) FROM dbo.truyen";
        ResultSet rs = null;
        Integer amount = 23;
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        try {
            while(rs.next()){
                amount = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return amount;
    }
    
}
