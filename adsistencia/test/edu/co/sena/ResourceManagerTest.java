/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena;

import edu.co.sena.adsistencia.modelo.dao.mysql.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author users
 */
public class ResourceManagerTest {
    
    public ResourceManagerTest() {
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
     * Test of getConection method, of class ResourceManager.
     */
   @Test
    public void GetConection() throws SQLException {
        System.out.println("getConection");
        Connection resultado = ResourceManager.getConection();
        resultado.close();

    }

    @Test
    public void CloseConection() throws SQLException {
        System.out.println("closeConection");

        Connection resultado = ResourceManager.getConection();
        ResourceManager.close(resultado);

    }

    @Test
    public void CloseAll() throws SQLException {
        System.out.println("closeConection");

        Connection conexion = ResourceManager.getConection();
        ResultSet rs = null;
        PreparedStatement sentencia = null;
        String sqlPrepared = "SELECT * FROM adsistencia.equipo where ID_EQUIPO = ? ;";
        sentencia = conexion.prepareStatement(sqlPrepared);
        sentencia.setInt(1, 1);
        rs = sentencia.executeQuery();

        if (!rs.wasNull()) {
            while (rs.next()) {
                System.out.println("id Equipo: " + rs.getInt(1));

                System.out.println("______________________");
            }

        }
        ResourceManager.close(rs);
        ResourceManager.close(sentencia);
        
        ResourceManager.close(conexion);

    }
}
