/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao.mysql;

import edu.co.sena.adsistencia.modelo.dao.RegistroEquipoDao;
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipo;
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipoPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author users
 */
public class RegistroEquipoDaoImpl implements RegistroEquipoDao {

    private Connection conexion;
    private final String SQL_SELECT = "select * from " + getTableName() 
            + "";
    private final String SQL_INSERT = "INSERT INTO " + getTableName() 
            + "\n"
            + "(REGISTRO_NUM_REGISTRO ,"
            + "PROPIETARIO_EQUIPO_ID_EQUIPO, "
            + "PROPIETARIO_USUARIO_TIPO_DOCUMENTO,"
            + "PROPIETARIO_USUARIO_NUM_DOCUMENTO,"
            + "FECHA_ENTRADA,"
            + "FECHA_SALIDA)\n"
            + "VALUES (?,?,?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE " + getTableName() 
            + " SET \n"
           
            + "FECHA_ENTRADA = ?,\n"
            + "FECHA_SALIDA = ?\n"
            + "WHERE REGISTRO_NUM_REGISTRO= ? "
            + "AND PROPIETARIO_EQUIPO_ID_EQUIPO = ?"
            + " AND PROPIETARIO_USUARIO_TIPO_DOCUMENTO = ? "
            + "AND PROPIETARIO_USUARIO_NUM_DOCUMENTO= ?;";
    private final String SQL_DELETE = "DELETE FROM  " + getTableName() + " WHERE REGISTRO_NUM_REGISTRO = ? AND PROPIETARIO_EQUIPO_ID_EQUIPO = ? AND PROPIETARIO_USUARIO_TIPO_DOCUMENTO = ? AND PROPIETARIO_USUARIO_NUM_DOCUMENTO= ?;";
    private final String SQL_COUNT = "select count(*) from " + getTableName() + " ;  ";

    public List<RegistroEquipo> findAll() {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegistroEquipo> lt = new ArrayList<>();

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
                    RegistroEquipo r1 = new RegistroEquipo();
                    r1.setRegistroNumRegistro(rs.getInt(1));
                    r1.setPropietarioEquipoIdEquipo(rs.getInt(2));
                    r1.setPropietarioTipoDocumento(rs.getString(3));
                    r1.setPropietarioUsuarioNumDocumento(rs.getString(4));
                    r1.setFechaEntrada(rs.getTimestamp(5));

                    r1.setFechaSalida(rs.getTimestamp(6));

                    lt.add(r1);
                }
            }

        } catch (Exception e) {
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

    public void insert(RegistroEquipo dto) {

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
            stmt.setInt(indice++, dto.getRegistroNumRegistro());
            stmt.setInt(indice++, dto.getPropietarioEquipoIdEquipo());
            stmt.setString(indice++, dto.getPropietarioTipoDocumento());
            stmt.setString(indice++, dto.getPropietarioUsuarioNumDocumento());
            stmt.setTimestamp(indice++, dto.getFechaEntrada());
            stmt.setTimestamp(indice++, dto.getFechaSalida());
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error en el findAll " + e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }

    }

    public void update(RegistroEquipoPK llaveDto, RegistroEquipo dto) {

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
            stmt.setTimestamp(indice++, dto.getFechaEntrada());
            stmt.setTimestamp(indice++, dto.getFechaSalida());
            stmt.setInt(indice++, llaveDto.getRegistroNumRegistro());
            stmt.setInt(indice++, llaveDto.getPropietarioEquipoIdEquipo());
            stmt.setString(indice++, llaveDto.getPropietarioUsuarioTipoDocumento());
            stmt.setString(indice++, llaveDto.getPropietarioUsuarioNumDocumento());

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

    public void delete(RegistroEquipoPK dto) {

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
            stmt.setInt(indice++, dto.getRegistroNumRegistro());
            stmt.setInt(indice++, dto.getPropietarioEquipoIdEquipo());
            stmt.setString(indice++, dto.getPropietarioUsuarioTipoDocumento());
            stmt.setString(indice++, dto.getPropietarioUsuarioNumDocumento());

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
            // obtener el la conexion 

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

            // construct the SQL statement
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
        return "adsistencia.registroequipo";
    }

     public List<RegistroEquipoPK> findAllPK() 
    {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegistroEquipoPK> lt = new ArrayList<>();

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
                    RegistroEquipoPK epk = new RegistroEquipoPK();
                epk.setRegistroNumRegistro(rs.getInt(1));
                epk.setPropietarioEquipoIdEquipo(rs.getInt(2));
                epk.setPropietarioUsuarioTipoDocumento(rs.getString(3));
                epk.setPropietarioUsuarioNumDocumento(rs.getString(4));
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
