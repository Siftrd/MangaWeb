/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.Vector;
import model.TheLoai;
import model.Truyen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hung Dinh
 */
public class TruyenDaoTest {
    
    public TruyenDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of themTruyen method, of class TruyenDao.
     */
    @Test
    public void testThemTruyen() {
        System.out.println("themTruyen");
        Truyen t = null;
        TruyenDao instance = new TruyenDao();
        Boolean expResult = null;
        Boolean result = instance.themTruyen(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of suaTruyen method, of class TruyenDao.
     */
    @Test
    public void testSuaTruyen() {
        System.out.println("suaTruyen");
        Truyen t = null;
        TruyenDao instance = new TruyenDao();
        Boolean expResult = null;
        Boolean result = instance.suaTruyen(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of xoaTruyen method, of class TruyenDao.
     */
    @Test
    public void testXoaTruyen() {
        System.out.println("xoaTruyen");
        String id = "";
        TruyenDao instance = new TruyenDao();
        Boolean expResult = null;
        Boolean result = instance.xoaTruyen(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTruyen method, of class TruyenDao.
     */
    @Test
    public void testGetTruyen() {
        System.out.println("getTruyen");
        int soLuong = 0;
        int page = 0;
        TruyenDao instance = new TruyenDao();
        Vector<Truyen> expResult = null;
        Vector<Truyen> result = instance.getTruyen(soLuong, page);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTheLoai method, of class TruyenDao.
     */
    @Test
    public void testGetTheLoai() {
        System.out.println("getTheLoai");
        TruyenDao instance = new TruyenDao();
        Vector<TheLoai> expResult = null;
        Vector<TheLoai> result = instance.getTheLoai();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countTruyen method, of class TruyenDao.
     */
    @Test
    public void testCountTruyen() {
        System.out.println("countTruyen");
        TruyenDao instance = new TruyenDao();
        Integer expResult = null;
        Integer result = instance.countTruyen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dongKetnoi method, of class TruyenDao.
     */
    @Test
    public void testDongKetnoi() {
        System.out.println("dongKetnoi");
        TruyenDao instance = new TruyenDao();
        instance.dongKetnoi();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
