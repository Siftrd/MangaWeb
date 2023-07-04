/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package util;

import com.google.gson.JsonObject;
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
public class JsonConverterTest {
    
    public JsonConverterTest() {
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
     * Test of convertJsonToObject method, of class JsonConverter.
     */
    @Test
    public void testConvertJsonToObject() {
        System.out.println("convertJsonToObject");
        Object o = null;
        JsonConverter instance = null;
        Object expResult = null;
        Object result = instance.convertJsonToObject(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJsonObject method, of class JsonConverter.
     */
    @Test
    public void testGetJsonObject() {
        System.out.println("getJsonObject");
        JsonConverter instance = null;
        JsonObject expResult = null;
        JsonObject result = instance.getJsonObject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJsonString method, of class JsonConverter.
     */
    @Test
    public void testGetJsonString() {
        System.out.println("getJsonString");
        JsonConverter instance = null;
        String expResult = "";
        String result = instance.getJsonString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
