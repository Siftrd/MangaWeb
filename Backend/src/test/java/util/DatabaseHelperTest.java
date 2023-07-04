/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package util;

import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
public class DatabaseHelperTest {

    private static DatabaseHelper instance;
    private static Connection conn = null;
//    private MongoDatabase mongo = null;
    private static Statement stmt = null;

    public DatabaseHelperTest() {
    }

    @BeforeClass
    public static void setUpDatabase() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://" + "DESKTOP-F90LHD8" + 
                ";databaseName=BTLWEB;encrypt=false";
        String user = "sa";
        String pass = "1";
        conn = DriverManager.getConnection(url, user, pass);
        // gui cau lenh sql den may chu
        stmt = conn.createStatement();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        if(conn != null) {
            conn.close();
            conn = null;
        }
        if(stmt != null) {
            stmt.close();
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSingletonInstance method, of class DatabaseHelper.
     */
    @Test
    public void testGetSingletonInstance() {
        DatabaseHelper expResult = instance;
        DatabaseHelper result = DatabaseHelper.getSingletonInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statementCreate method, of class DatabaseHelper.
     */
    @Test
    public void testStatementCreate() {
        System.out.println("statementCreate");
        DatabaseHelper instance = null;
        instance.statementCreate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connnect method, of class DatabaseHelper.
     */
    @Test
    public void testConnnect() {
        DatabaseHelper instance = DatabaseHelper.getSingletonInstance();
        instance.connnect();
    }

    /**
     * Test of connectMongoDB method, of class DatabaseHelper.
     */
    @Test
    public void testConnectMongoDB() {
        System.out.println("connectMongoDB");
        DatabaseHelper instance = null;
        instance.connectMongoDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConn method, of class DatabaseHelper.
     */
    @Test
    public void testGetConn() {
        System.out.println("getConn");
        DatabaseHelper instance = null;
        Connection expResult = null;
        Connection result = instance.getConn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStmt method, of class DatabaseHelper.
     */
    @Test
    public void testGetStmt() {
        System.out.println("getStmt");
        DatabaseHelper instance = null;
        Statement expResult = null;
        Statement result = instance.getStmt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMongo method, of class DatabaseHelper.
     */
    @Test
    public void testGetMongo() {
        System.out.println("getMongo");
        DatabaseHelper instance = null;
        MongoDatabase expResult = null;
        MongoDatabase result = instance.getMongo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
