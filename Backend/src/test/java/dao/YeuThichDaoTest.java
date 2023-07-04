/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

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
public class YeuThichDaoTest {
    
    public YeuThichDaoTest() {
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
     * Test of getYeuThichById method, of class YeuThichDao.
     */
    @Test
    public void testGetYeuThichById() {
        System.out.println("getYeuThichById");
        String userName = "";
        YeuThichDao instance = new YeuThichDao();
        String expResult = "";
        String result = instance.getYeuThichById(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addYeuThichById method, of class YeuThichDao.
     */
    @Test
    public void testAddYeuThichById() {
        System.out.println("addYeuThichById");
        String userName = "";
        Truyen t = null;
        YeuThichDao instance = new YeuThichDao();
        instance.addYeuThichById(userName, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewDanhSachYeuThichById method, of class YeuThichDao.
     */
    @Test
    public void testAddNewDanhSachYeuThichById() {
        System.out.println("addNewDanhSachYeuThichById");
        String userName = "";
        YeuThichDao instance = new YeuThichDao();
        instance.addNewDanhSachYeuThichById(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
