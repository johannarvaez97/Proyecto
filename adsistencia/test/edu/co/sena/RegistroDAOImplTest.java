/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena;

import edu.co.sena.adsistencia.modelo.dao.RegistroDao;
import edu.co.sena.adsistencia.modelo.dto.Registro;
import edu.co.sena.adsistencia.modelo.dto.RegistroPK;
import edu.co.sena.adsistencia.modelo.factory.DaoAbstractFactory;
import edu.co.sena.adsistencia.modelo.factory.DaoFactory;
import edu.co.sena.adsistencia.modelo.factory.MysqlDaoFactory;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class RegistroDAOImplTest {
    
    public RegistroDAOImplTest() {
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
     * Test of findAll method, of class RegistroDAOImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroDao instance = fdao.createRegistroDAO();

        List<Registro> result = instance.findAll();
        for (Registro result1 : result) {
            System.out.println(result1);
        }

    }

    /**
     * Test of insert method, of class RegistroDAOImpl.
     */
    @Test
    public void Insert() {
        System.out.println("Insert registro");
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(1997, 12, 2, 3, 6, 45);
        Timestamp t = new Timestamp(calendar.getTimeInMillis());

        Calendar calendar1 = GregorianCalendar.getInstance();
        calendar.set(1997, 12, 2, 3, 9, 59);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

        Registro registro1 = new Registro();
        registro1.setNumRegistro(1);
        registro1.setFechaEntrada( t);
        registro1.setFechaSalida(timestamp);
        registro1.setUsuarioTipoDocumento("cedulaciudadana");
        registro1.setUsuarioNumDocumento("123456433");
        registro1.setRolRegistro("aprendiz");
        registro1.setMotivoVisita("");

        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);

        RegistroDao instance = daoFactory.createRegistroDAO();
        instance.insert(registro1);

    }

    @Test
    public void Update() {
        System.out.println("Update registro");

        Calendar calendar = GregorianCalendar.getInstance();
         calendar.set(1997, 12, 2, 3, 6, 45);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

        Calendar calendar1 = GregorianCalendar.getInstance();
        calendar.set(1997, 12, 2, 3, 9, 59);
       
        Timestamp t = new Timestamp(calendar.getTimeInMillis());

        RegistroPK llave = new RegistroPK(1);
        Registro registroUpdate = new Registro();
        registroUpdate.setFechaEntrada(timestamp);
        registroUpdate.setFechaSalida(t);
        registroUpdate.setRolRegistro("administrador");
        registroUpdate.setMotivoVisita("");

        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroDao instance = daoFactory.createRegistroDAO();
        instance.update(llave, registroUpdate);

    }

    @Test
    public void Delete() {

        System.out.println("Delete registro");

        RegistroPK registroPK = new RegistroPK(1);

        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);

        RegistroDao instance = daoFactory.createRegistroDAO();
        instance.delete(registroPK);

    }

    @Test
    public void Count() {
        System.out.println("Count registro");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroDao instance = daoFactory.createRegistroDAO();
        System.out.println(instance.count());;
    }

    @Test
    public void FindByPK() {
        System.out.println("findByPK registro");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroDao instance = daoFactory.createRegistroDAO();

        List<RegistroPK> registroPKs = instance.findByPK();

        for (RegistroPK k : registroPKs) {
            System.out.println(k);
        }
    }

}
