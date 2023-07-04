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
public class UserTest {

    public UserTest() {
    }

    User user1 = new User("Dinh", "Hung", "Hung Dinh", 1);
    User user2 = new User();

    @Test
    public void testGetType() {
        int expResult = 1;
        int result = user1.getType();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFirstName() {
        String expResult = "Dinh";
        String result = user1.getFirstName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetFirstName() {
        String firstName = "Bui";
        user2.setFirstName(firstName);
        assertEquals(user2.getFirstName(), firstName);
    }

    @Test
    public void testGetLastName() {
        String expResult = "Hung";
        String result = user1.getLastName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetLastName() {
        String firstName = "Duc";
        user2.setFirstName(firstName);
        assertEquals(user2.getFirstName(), firstName);
    }

    @Test
    public void testGetUserName() {
        String expResult = "Hung Dinh";
        String result = user1.getUserName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmail() {
        String expResult = "gioidv.b19dccn210@gmail.com";
        user2.setEmail("gioidv.b19dccn210@gmail.com");
        String result = user2.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEmail() {
        String email = "gioidv.b19dccn210@gmail.com";
        user2.setEmail(email);
        String result = user2.getEmail();
        assertEquals(email, result);
    }

}
