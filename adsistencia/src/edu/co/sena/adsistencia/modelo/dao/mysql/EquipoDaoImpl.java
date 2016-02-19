/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao.mysql;

import edu.co.sena.adsistencia.modelo.dao.EquipoDao;
import edu.co.sena.adsistencia.modelo.dto.Equipo;
import edu.co.sena.adsistencia.modelo.dto.EquipoPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author users
 */
public class EquipoDaoImpl implements EquipoDao {

    private Connection conexion;
    private final String SQL_SELECT = "select * from " + getTableName() + "";
    private final String SQL_INSERT
            = "INSERT INTO adsistencia.equipo "
            + "(ID_EQUIPO,"
            + "MARCA,"
            + "NUM_SERIAL,"
            + "DESCRIPCION)"
            + "VALUES"
            + "(?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE " + getTableName()
            + " SET "
            + "ID_EQUIPO =?,"
            + " MARCAcuenta = ?,"
            + "NUM_SERIAL = ?,"
            + "DESCRIPCION = ? "
            + "WHERE ID_EQUIPO = ?;";
    ;
    private final String SQL_UPDATEPK = "UPDATE  " + getTableName() + " SET \n"
            + " ID_EQUIPO = ? \n"
            + "  WHERE ID_EQUIPO = ? ;";
    
    
    private final  String SQL_DELETE = 
            "DELETE FROM "
            +getTableName()
            + " WHERE ID_EQUIPO = ?;";
    
    private final String SQL_COUNT = "Select count(*) from "+ getTableName() +" ; ";

    @Override
    public List<Equipo> findAll() {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Equipo> lt = new ArrayList<>();

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
                    Equipo ct = new Equipo();
                    ct.setIdEquipo(rs.getInt(1));
                    ct.setMarca(rs.getString(2));
                    ct.setNumSerial(rs.getString(3));
                    ct.setDescripcion(rs.getString(4));
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

    public void insert(Equipo dto) {

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
            stmt.setInt(indice++, dto.getIdEquipo());
            stmt.setString(indice++, dto.getMarca());
            stmt.setString(indice++, dto.getNumSerial());
            stmt.setString(indice++, dto.getDescripcion());

            rs = stmt.executeUpdate();

        } catch (Exception _e) {
            System.out.println("error en el findAll");
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }

    }

    public void update(EquipoPK llaveDto, Equipo dto) {

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

            final String SQL = SQL_UPDATE;
            int indice = 1;
            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setString(indice++, dto.getMarca());
            stmt.setString(indice++, dto.getNumSerial());
            stmt.setString(indice++, dto.getDescripcion());
            stmt.setInt(indice++, llaveDto.getIdEquipo());

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

    public void updatePk(EquipoPK viejo, EquipoPK nuevo) {

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

            final String SQL = SQL_UPDATEPK;
            int indice = 1;
            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(indice++, nuevo.getIdEquipo());
            stmt.setInt(indice++, viejo.getIdEquipo());

            rs = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("error en el findAll"+e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }

    }
    
    public void delete(EquipoPK dto) {
     
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
            stmt.setInt(indice++, dto.getIdEquipo());
            

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
        return "adsistencia.equipo";
    }
    
   
    public List<EquipoPK> findAllPK() 
    {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EquipoPK> lt = new ArrayList<>();

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
                    EquipoPK epk = new EquipoPK();
                    epk.setIdEquipo(rs.getInt(1));
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
