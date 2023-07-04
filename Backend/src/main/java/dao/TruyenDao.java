/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.DocTruyenController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TheLoai;
import model.Truyen;
import util.DatabaseHelper;

/**
 *
 * @author suckm
 */
public class TruyenDao {

    Connection con = null;

    public TruyenDao() {
        DatabaseHelper dbh = DatabaseHelper.getSingletonInstance();
        con = dbh.getConn();
    }

    public Boolean themTruyen(Truyen t) {
        SearchDao sd = new SearchDao();
        String query = "INSERT INTO [dbo].[truyen]([idTruyen],[ten],[nxb],[idTheLoai],[stt])VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getId());
            ps.setString(2, t.getTen());
            ps.setString(3, t.getNxb());
            ps.setString(4, t.getTheLoai());
            ps.setInt(5, sd.countTruyen() + 1);
            ps.execute();
            System.out.println("Them Truyen Thanh Cong");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TruyenDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Them Truyen Khong Thanh Cong");
        }
//        dongKetnoi();
        return false;
    }

    public Boolean suaTruyen(Truyen t) {
        SearchDao sd = new SearchDao();
        String query = "UPDATE [dbo].[truyen] set ten = ?, nxb = ?, idTheLoai = ? where idTruyen = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getTen());
            ps.setString(2, t.getNxb());
            ps.setString(3, t.getTheLoai());
            ps.setString(4, t.getId());
            ps.execute();
            System.out.println("Sua Truyen Thanh Cong");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TruyenDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Sua Truyen Khong Thanh Cong");
        }
        return false;
    }

    public Boolean xoaTruyen(String id) {
        SearchDao sd = new SearchDao();
        String query = "DELETE FROM [dbo].[truyen] where idTruyen = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Xoa Truyen Thanh Cong");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TruyenDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Xoa Truyen Khong Thanh Cong");
        }
        return false;
    }

    public Vector<Truyen> getTruyen(int soLuong, int page) {
        String query = "select * from dbo.truyen\n"
                + "order by dbo.truyen.stt asc\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT 10 ROWS ONLY";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 10 * (page - 1));
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ko co truyen");
        }

        Vector<Truyen> ts = new Vector<>();
        try {
            while (rs.next()) {
                Truyen t = new Truyen(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ts.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ts;
    }

    public Vector<TheLoai> getTheLoai() {
        String query = "select * from dbo.theloai";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ko co truyen");
        }

        Vector<TheLoai> tls = new Vector<>();
        try {
            while (rs.next()) {
                TheLoai tl = new TheLoai(rs.getString(1), rs.getString(2));
                tls.add(tl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocTruyenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tls;
    }

    public Integer countTruyen() {
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
            while (rs.next()) {
                amount = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return amount;
    }

    public void dongKetnoi() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TruyenDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
