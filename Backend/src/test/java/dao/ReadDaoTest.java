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
public class ReadDaoTest {

    public ReadDaoTest() {
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
     * Test of getTruyenInfoByID method, of class ReadDao.
     */
    @Test
    public void testGetTruyenInfoByID() {
        String id = "DRM1";
        ReadDao instance = new ReadDao();
        Truyen expResult = new Truyen(id, "Doremon tap 1", "Kim Dong", 0);
        Truyen result = instance.getTruyenInfoByID(id);
        assertEquals(expResult.toString(), result.toString());
    }

}
