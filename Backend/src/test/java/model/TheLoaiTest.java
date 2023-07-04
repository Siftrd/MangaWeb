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
public class TheLoaiTest {
    
    public TheLoaiTest() {
    }
    
    TheLoai theLoai = new TheLoai("hai", "Truyen hai");

    @Test
    public void testGetId() {
        String expResult = "hai";
        String result = theLoai.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTen() {
        String expResult = "Truyen hai";
        String result = theLoai.getTen();
        assertEquals(expResult, result);
    }
    
}
