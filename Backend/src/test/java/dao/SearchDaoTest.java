/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.Vector;
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
public class SearchDaoTest {

    public SearchDaoTest() {
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
     * Test of searchByTen method, of class SearchDao.
     */
    @Test
    public void testSearchByTen() {
        String nd = "Doremon";
        SearchDao instance = new SearchDao();
        Vector<Truyen> expResult = new Vector<>();
        expResult.add(new Truyen("DRM1", "Doremon tap 1", "Kim Dong", 0));
        expResult.add(new Truyen("DRM2", "Doremon tap 2", "Dong Kim", 0));

        Vector<Truyen> result = instance.searchByTen(nd);
        String results = result.toString();
        String exp = expResult.toString();
        boolean testResult = results.contains(exp);
//        boolean testResult = result.firstElement().toString().equals(expResult.firstElement().toString());
assertTrue("Truyen nay co ton tai", testResult);
    }

    /**
     * Test of searchByTheLoai method, of class SearchDao.
     */
    @Test
    public void testSearchByTheLoai() {
        String idTheLoai = "tnl";
        SearchDao instance = new SearchDao();
        Vector<Truyen> expResult = new Vector<>();
        expResult.add(new Truyen("DRM1", "Doremon tap 1", "Kim Dong", "tnl"));
        expResult.add(new Truyen("50SOG01", "50 Sac Thai", "Vintage Books", "tnl"));
        Vector<Truyen> result = instance.searchByTheLoai(idTheLoai);
        String results = result.toString();
        String expResult1 = expResult.get(0).toString();
        boolean b1 = results.contains(expResult1);
        assertTrue("Truyen 1 khong ton tai", b1);
        String expResult2= expResult.get(0).toString();
        boolean b2 = results.contains(expResult2);
        assertTrue("Truyen 2 khong ton tai", b2);
    }

    /**
     * Test of getTruyen method, of class SearchDao.
     */
    @Test
    public void testGetTruyen() {
        System.out.println("getTruyen");
        int soLuong = 0;
        int page = 0;
        SearchDao instance = new SearchDao();
        Vector<Truyen> expResult = null;
        Vector<Truyen> result = instance.getTruyen(soLuong, page);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countTruyen method, of class SearchDao.
     */
    @Test
    public void testCountTruyen() {
        System.out.println("countTruyen");
        SearchDao instance = new SearchDao();
        Integer expResult = null;
        Integer result = instance.countTruyen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
