/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hung Dinh
 */
public class TruyenTest {
    
    public TruyenTest() {
    }
    
    Truyen truyen = new Truyen("DRM1", "Doraemon tap 1", "Kim Dong", "tt");
    
    @Test
    public void testGetId() {
        String expResult = "DRM1";
        String result = truyen.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTen() {
        String expResult = "Doraemon tap 1";
        String result = truyen.getTen();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNxb() {
        String expResult = "Kim Dong";
        String result = truyen.getNxb();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTheLoai() {
        String expResult = "tt";
        String result = truyen.getTheLoai();
        assertEquals(expResult, result);
    }

    Truyen truyen2 = new Truyen("DRM1", "Doraemon tap 1", "Kim Dong", 1);
    
    @Test
    public void testGetRating() {
        int expResult = 1;
        int result = truyen2.getRating();
        assertEquals(expResult, result);
    }
    
}
