/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena;


import edu.co.sena.adsistencia.modelo.dao.EquipoDao;
import edu.co.sena.adsistencia.modelo.dao.mysql.EquipoDaoImpl;
import edu.co.sena.adsistencia.modelo.dto.Equipo;
import edu.co.sena.adsistencia.modelo.dto.EquipoPK;
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
public class EquipoDAOImplTest {

    public EquipoDAOImplTest() {
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
    public void FindAll() {
        System.out.println("findAll");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        EquipoDao instance = daoFactory.createEquipoDAO();
        List<Equipo> result = instance.findAll();
        for (Equipo equipo : result) {
            System.out.println(equipo.toString());
        }
    }

    @Test
    public void Insert() {
        System.out.println("insertar Equipo");
        Equipo equipo1 = new Equipo();
        equipo1.setIdEquipo(7);
        equipo1.setMarca("pavilion");
        equipo1.setNumSerial("12343mk45km45k");
        equipo1.setDescripcion("rota la pantalla");
        DaoFactory FDAO = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        EquipoDao instance = FDAO.createEquipoDAO();
        instance.insert(equipo1);
    }

    @Test
    public void Update() {
        System.out.println("actualizar equipo");
        EquipoPK equipoPK = new EquipoPK(1);
        Equipo EquipoNuevo = new Equipo();
        EquipoNuevo.setIdEquipo(7);
        EquipoNuevo.setMarca("lenovo");
        
        EquipoNuevo.setNumSerial("sa98d989f8s09");
        EquipoNuevo.setDescripcion("sin pila");
        DaoFactory FDAO = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        EquipoDao ins = FDAO.createEquipoDAO();
        ins.update(equipoPK, EquipoNuevo);

    }

    @Test
    public void UpdatePk() {
        System.out.println("Equipo actualizar");
        EquipoPK Vieja = new EquipoPK(4234);
        EquipoPK Nueva = new EquipoPK(73254);
        DaoFactory FDAO = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        EquipoDao ins = FDAO.createEquipoDAO();
        ins.updatePk(Vieja, Nueva);
    }

    @Test
    public void testDelete() {
        System.out.println("eliminar ");
        EquipoDao equipoDao = new EquipoDaoImpl();
        EquipoPK llavesBorrar = new EquipoPK(4234);
        DaoFactory FDAO = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        EquipoDao instance = FDAO.createEquipoDAO();
        instance.delete(llavesBorrar);
    }

    @Test
    public void testCount() {
        System.out.println("Count");
        EquipoDao equipoDao = new EquipoDaoImpl();
        DaoFactory FDAO = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        EquipoDao instance = FDAO.createEquipoDAO();
        System.out.println(instance.count());
    }

    @Test
    public void testFindPK() {
        System.out.println("findAllPK");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        EquipoDao instance = daoFactory.createEquipoDAO();
        List<EquipoPK> result = instance.findAllPK();
        for (EquipoPK equipopk : result) {
            System.out.println(equipopk.toString());
        }
    }
}
