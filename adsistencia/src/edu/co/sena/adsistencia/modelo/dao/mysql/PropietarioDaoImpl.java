/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao.mysql;

import edu.co.sena.adsistencia.modelo.dao.PropietarioDao;
import edu.co.sena.adsistencia.modelo.dto.Propietario;
import edu.co.sena.adsistencia.modelo.dto.PropietarioPK;
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipoPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author users
 */

public class PropietarioDaoImpl implements PropietarioDao {

    private Connection conexion;
    private final String SQL_SELECT = "select * from " + getTableName() + "";
    private final String SQL_INSERT = "INSERT INTO ADSISTENCIA.propietario "
            + "(USUARIO_TIPO_DOCUMENTO,"
            + "USUARIO_NUM_DOCUMENTO,"
            + "EQUIPO_ID_EQUIPO)"
            + "VALUES" 
            + "(?,?,?);";
    private final String SQL_DELETE = " DELETE FROM " + getTableName() 
            + " WHERE  USUARIO_TIPO_DOCUMENTO = ?"
            + " and USUARIO_NUM_DOCUMENTO = ?"
            + " and EQUIPO_ID_EQUIPO=?;";

    private final String SQL_COUNT = " select count(*) from " + getTableName() 
            + " ; ";

    public List<Propietario> findAll() {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Propietario> lt = new ArrayList<>();

        try {

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

            final String SQL = SQL_SELECT;

            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            rs = stmt.executeQuery();

            if (!rs.wasNull()) {
                while (rs.next()) {
                    Propietario ct = new Propietario();
                    ct.setUsuarioTipoDocumento(rs.getString(1));
                    ct.setUsuarioNumDocumento(rs.getString(2));
                    ct.setEquipoIdEquipo(rs.getString(3));
                    lt.add(ct);
                }
            }

        } catch (Exception _e) {
            System.out.println("error en el findAll");
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }
        return lt;
    }

    public void insert(Propietario dto) {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs;

        try {

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

          
            final String SQL = SQL_INSERT;
            int indice = 1;
            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);

            stmt.setString(indice++, dto.getUsuarioTipoDocumento());
            stmt.setString(indice++, dto.getUsuarioNumDocumento());
            stmt.setString(indice++, dto.getEquipoIdEquipo());

            rs = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("error en el findAll" + e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }

    }

    public void delete(PropietarioPK dot) {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs;

        try {

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

          
            final String SQL = SQL_DELETE;
            int indice = 1;
            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setString(indice++, dot.getUsuarioTipoDocumento());
            stmt.setString(indice++, dot.getUsuarioNumDocumento());
            stmt.setString(indice++, dot.getEquipoIdEquipo());

            rs = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("error en el findAll" + e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }
    }
    
    
     public int count() {
        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int r = 0;
        try {
           

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

           
            final String SQL = SQL_COUNT;
            stmt = conn.prepareStatement(SQL);
            System.out.println("se ejecuto " + SQL);
            rs = stmt.executeQuery();
            rs.next();
            r = rs.getInt(1);
        } catch (Exception e) {
            System.out.println("error en el findAll" + e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }
        return r;
    }

    public String getTableName() {
        return "adsistencia.propietario";
    }
    
     public List<PropietarioPK> findAllPK() 
    {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PropietarioPK> lt = new ArrayList<>();

        try {

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

            final String SQL = SQL_SELECT;

            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            rs = stmt.executeQuery();

            if (!rs.wasNull()) {
                while (rs.next()) {
                    PropietarioPK epk = new PropietarioPK();
                   epk.setEquipoIdEquipo(rs.getString(3));
                   epk.setUsuarioTipoDocumento(rs.getString(1));
                   epk.setUsuarioNumDocumento(rs.getString(2));
                    lt.add(epk);
                }
            }

        } catch (Exception e) {
            System.out.println("error en el findAll"+e.getMessage());
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }
        return lt;
    }

   

}
