/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena;

import edu.co.sena.adsistencia.modelo.dao.PropietarioDao;
import edu.co.sena.adsistencia.modelo.dao.mysql.PropietarioDaoImpl;
import edu.co.sena.adsistencia.modelo.dto.Propietario;
import edu.co.sena.adsistencia.modelo.dto.PropietarioPK;
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
public class PropietarioDAOImplTest {

    public PropietarioDAOImplTest() {
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
        PropietarioDao instance = daoFactory.createPropietarioDAO();
        List<Propietario> result = instance.findAll();
        for (Propietario propi : result) {
            System.out.println(propi.toString());
        }
    }

    @Test
    public void Insert() {
        System.out.println("insertar propietario");
        Propietario propietario = new Propietario();
        propietario.setUsuarioTipoDocumento("CedulaCiudadana");
        propietario.setUsuarioNumDocumento("12432");
        propietario.setEquipoIdEquipo("4234");
        DaoFactory FDAO = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        PropietarioDao instance = FDAO.createPropietarioDAO();
        instance.insert(propietario);
    }

    @Test
    public void testDelete() {
        System.out.println("Delete");
        PropietarioDao propietarioDao = new PropietarioDaoImpl();
        PropietarioPK pK = new PropietarioPK("CC", "7920008", "7");
      DaoFactory df = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        PropietarioDao instance = df.createPropietarioDAO();
        instance.delete(pK);
    }

    @Test
    public void testCount() {
        System.out.println("Count");
        PropietarioDao propietarioDao = new PropietarioDaoImpl();
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        PropietarioDao instance = daoFactory.createPropietarioDAO();
        System.out.println(instance.count());
    }
  @Test
    public void FindAllPK() {
        System.out.println("findAllPK");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        PropietarioDao instance = daoFactory.createPropietarioDAO();
        List<PropietarioPK> result = instance.findAllPK();
        for (PropietarioPK propietarioPK : result) {
            System.out.println(propietarioPK.toString());
        }
    }
    
    
    
}
