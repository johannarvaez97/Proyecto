/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena;

import edu.co.sena.adsistencia.modelo.dao.UsuarioDao;
import edu.co.sena.adsistencia.modelo.dto.Usuario;
import edu.co.sena.adsistencia.modelo.dto.UsuarioPK;
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
 * @author uusers
 */
public class UsuarioDAOImplTest {
    
    public UsuarioDAOImplTest() {
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
     * Test of findAll method, of class UsuarioDAOImpl.
     */
    @Test
    public void findALL() {
        System.out.println("findALL");

        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        UsuarioDao usuario1 = fdao.createUsuarioDAO();
        List<Usuario> result = usuario1.findAll();

        for (Usuario lt1 : result) {
            System.out.println(lt1.toString());
        }

    }

    @Test
    public void insert() {
        System.out.println("Insert usuario");

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2018, 02, 12, 24, 00, 00);
        Timestamp t1 = new Timestamp(calendar.getTimeInMillis());

        Usuario usuario1 = new Usuario();
        usuario1.setTipoDocumento("CC");
        usuario1.setNumDocumento("1022428848");
        usuario1.setPrimerNombre("DAYANA");
        usuario1.setSegundoNombre("PATRICIA");
        usuario1.setPrimerApellido("CUESTA");
        usuario1.setSegundoApellido("ZAMORA");
        usuario1.setPerfil("APRENDIZ");
        usuario1.setFechaVencimiento(t1);
        usuario1.setEstado(true);
        usuario1.setFoto(null);
        

        DaoFactory fdao = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);

        UsuarioDao usuario = fdao.createUsuarioDAO();
        usuario.insert(usuario1);

    }

    @Test
    public void Update() {
        System.out.println("Update usuario");
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2018, 06, 02);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

        UsuarioPK pK = new UsuarioPK("CedulaCiudadana", "2193000000");
        Usuario usuario = new Usuario();
        usuario.setTipoDocumento("CedulaCiudadana");
        usuario.setNumDocumento("2187289000000");
        usuario.setPrimerNombre("clara");
        usuario.setSegundoNombre("maria");
        usuario.setPrimerApellido("garcia");
        usuario.setSegundoApellido("rivera");
        usuario.setPerfil("instructor");
        usuario.setFechaVencimiento(timestamp);
        usuario.setEstado(true);
        usuario.setFoto(null);

        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        UsuarioDao instance = daoFactory.createUsuarioDAO();
        instance.update(pK, usuario);

    }

    @Test
    public void UpdatePk() {
        System.out.println("update usuario");
        UsuarioPK Vieja = new UsuarioPK("cedulaextrangera", "7268999999");
        UsuarioPK Nueva = new UsuarioPK("targetaidentidad", "97030103100");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        UsuarioDao instance = daoFactory.createUsuarioDAO();
        instance.updatePk(Vieja, Nueva);
    }

    @Test
    public void Delete() {
        System.out.println("Delete usuario");
        UsuarioPK usuarioPK = new UsuarioPK();
        usuarioPK.setTipoDocumento("CC");
        usuarioPK.setNumDocumento("1016081489");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);

        UsuarioDao instance = daoFactory.createUsuarioDAO();
        instance.delete(usuarioPK);

    }

    @Test
    public void Count() {
        System.out.println("Count usuario");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        UsuarioDao instance = daoFactory.createUsuarioDAO();
        System.out.println(instance.count());

    }

    @Test
    public void FindByPK() {
        System.out.println("findByPK usuario");
        DaoFactory daoFactory = MysqlDaoFactory.getDAOFactory(DaoAbstractFactory.MYSQL_FACTORY);
        UsuarioDao instance = daoFactory.createUsuarioDAO();

        List<UsuarioPK> findByPK = instance.findByPK();

        for (UsuarioPK k : findByPK) {
            System.out.println(k);
        }
    }

}
