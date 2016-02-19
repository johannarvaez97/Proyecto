/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena;

import edu.co.sena.adsistencia.modelo.dto.RegistroEquipoPK;
import edu.co.sena.adsistencia.modelo.dao.RegistroEquipoDao;
import edu.co.sena.adsistencia.modelo.dao.mysql.RegistroEquipoDaoImpl;
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipo;
import edu.co.sena.adsistencia.modelo.factory.DaoAbstractFactory;
import edu.co.sena.adsistencia.modelo.factory.DaoFactory;
import edu.co.sena.adsistencia.modelo.factory.MysqlDaoFactory;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
public class RegistroEquipoImplTest {

    public RegistroEquipoImplTest() {
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

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        RegistroEquipoDao registroEquipoDao = new RegistroEquipoDaoImpl();
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroEquipoDao instance = daoFactory.createRegistroEquipoDAO();
        List<RegistroEquipo> registroEquipos = instance.findAll();
        for (RegistroEquipo registro2 : registroEquipos) {
            System.out.println(registro2.toString());
        }
    }

    @Test
    public void testInsert() {

        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(1345, 11, 3, 24, 35, 40);
        Timestamp timestamp = new Timestamp(c1.getTimeInMillis());
        Calendar c2 = GregorianCalendar.getInstance();
        c1.set(1345, 11, 3, 24, 35, 56);
        Timestamp t = new Timestamp(c1.getTimeInMillis());
        System.out.println("agregar nuevo registro de equipo ");
        RegistroEquipo r1 = new RegistroEquipo();
        r1.setRegistroNumRegistro(23);
        r1.setPropietarioEquipoIdEquipo(312);
        r1.setPropietarioTipoDocumento("cedulaetrangera");
        r1.setPropietarioUsuarioNumDocumento("123387823798");
        r1.setFechaEntrada(timestamp);
        r1.setFechaSalida(t);
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroEquipoDao instance = daoFactory.createRegistroEquipoDAO();
        instance.insert(r1);
    }

    @Test
    public void testUpdate() {
        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(1345, 11, 3, 24, 35, 40);
        Timestamp t = new Timestamp(c1.getTimeInMillis());
        Calendar calendar = GregorianCalendar.getInstance();
        c1.set(1345, 11, 3, 24, 35, 40);
        Timestamp timestamp = new Timestamp(c1.getTimeInMillis());
        System.out.println("update catalogo");
        RegistroEquipoPK llave = new RegistroEquipoPK(1, 2, "CC", "888454884");
        RegistroEquipo nuevoCatalogo = new RegistroEquipo();
        nuevoCatalogo.setFechaEntrada(t);
        nuevoCatalogo.setFechaSalida(timestamp);
        DaoFactory FDAO = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroEquipoDao instance = FDAO.createRegistroEquipoDAO();
        instance.update(llave, nuevoCatalogo);
    }

    @Test
    public void testDelete() {
        System.out.println("Delete");
        RegistroEquipoDao registroEquipoDao = new RegistroEquipoDaoImpl();
        RegistroEquipoPK equipoPK = new RegistroEquipoPK(2, 3, "CC", "1022457851");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroEquipoDao instance = daoFactory.createRegistroEquipoDAO();
        instance.delete(equipoPK);
    }

    @Test
    public void testCount() {
        System.out.println("Count");
        RegistroEquipoDao equipoDao = new RegistroEquipoDaoImpl();
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroEquipoDao instance = daoFactory.createRegistroEquipoDAO();
        System.out.println(instance.count());
    }
    @Test
    public void testFindAllPK() {
        System.out.println("findAllPK");
        RegistroEquipoDao registroEquipoDao = new RegistroEquipoDaoImpl();
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        RegistroEquipoDao instance = daoFactory.createRegistroEquipoDAO();
        List<RegistroEquipoPK> result = instance.findAllPK();
        for (RegistroEquipoPK registro2 : result) {
            System.out.println(registro2.toString());
        }
    }

}
