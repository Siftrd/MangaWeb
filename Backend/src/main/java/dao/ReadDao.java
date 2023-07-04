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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Truyen;

/**
 *
 * @author suckm
 */
public class ReadDao {

    private Connection conn = null;
    public ReadDao() {
        DatabaseHelper dh = DatabaseHelper.getSingletonInstance();
        conn = dh.getConn();
        
    }
    
    public Truyen getTruyenInfoByID(String id){
        Truyen t = new Truyen("unknown", "unkown", "unknown", 0);
        Statement stm = null;
        try {
            stm = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(id);
        
        ResultSet rs = null;
        String query = "select * from truyen where idTruyen = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ko co result set");
        }
        
        try {
            while(rs.next()){
                t = new Truyen(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
}
