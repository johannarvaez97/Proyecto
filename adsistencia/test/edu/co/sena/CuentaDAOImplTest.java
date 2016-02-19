/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena;


import edu.co.sena.adsistencia.modelo.dao.CuentaDao;
import edu.co.sena.adsistencia.modelo.dto.Cuenta;
import edu.co.sena.adsistencia.modelo.dto.CuentaPK;
import edu.co.sena.adsistencia.modelo.factory.DaoAbstractFactory;
import edu.co.sena.adsistencia.modelo.factory.DaoFactory;
import edu.co.sena.adsistencia.modelo.factory.MysqlDaoFactory;
import java.util.List;
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
public class CuentaDAOImplTest {
    
    public CuentaDAOImplTest() {
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
     * Test of findAll method, of class CuentaDAOImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll cuenta");

        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        CuentaDao instance = daoFactory.createCuentaDAO();

        List<Cuenta> result = instance.findAll();

        for (Cuenta result1 : result) {
            System.out.println(result1);
        }
    }

    @Test
    public void Insert() {
        System.out.println(" cuenta insertar");
        Cuenta cuenta = new Cuenta();
        cuenta.setContrasena("01031997kj");
        cuenta.setRol("aprendz");
        cuenta.setUsuarioTipoDocumento("Cedula ciudadania");
        cuenta.setUsuarioNumDocumento("1022424712");
        cuenta.setCorreoElectronico("kevinrincon_97@hotmail.com");

        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);

        CuentaDao instance = fdao.createCuentaDAO();
        instance.insert(cuenta);

    }

    @Test
    public void Update() {
        System.out.println(" cuenta actualizar ");
        CuentaPK llave = new CuentaPK("cedula extrangera", "12345679097");

        Cuenta cuentaUpdate = new Cuenta();
        cuentaUpdate.setContrasena("01031997yus");
        cuentaUpdate.setRol("celador");
        cuentaUpdate.setCorreoElectronico("celacho@misena.edu.co");

        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        CuentaDao instance = fdao.createCuentaDAO();
        instance.update(llave, cuentaUpdate);

    }

    @Test
    public void Delete() {
        System.out.println(" cuenta eliminar");
        CuentaPK cuenta = new CuentaPK();
        cuenta.setUsuarioTipoDocumento("CedulaCiudadana");
        cuenta.setUsuarioNumDocumento("1234567890");
        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);

        CuentaDao instance = fdao.createCuentaDAO();
        instance.delete(cuenta);

    }

    @Test
    public void Count() {
        System.out.println("Count c");
        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        CuentaDao instance = fdao.createCuentaDAO();
        System.out.println(instance.count());

    }

    @Test
    public void FindByPK() {
        System.out.println("findByPK cuenta");
        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        CuentaDao instance = fdao.createCuentaDAO();

        List<CuentaPK> result = instance.findByPK();

        for (CuentaPK result1 : result) {
            System.out.println(result1);
        }
    }

}
