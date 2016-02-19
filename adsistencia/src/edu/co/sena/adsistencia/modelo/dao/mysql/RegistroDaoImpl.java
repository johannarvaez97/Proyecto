/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao.mysql;

import edu.co.sena.adsistencia.modelo.dao.RegistroDao;
import edu.co.sena.adsistencia.modelo.dto.Registro;
import edu.co.sena.adsistencia.modelo.dto.RegistroPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class RegistroDaoImpl implements RegistroDao {

    private Connection conexion;

    private final String SQL_SELECT = "select * from " + getTableName() 
            + "";

    private final String SQL_INSERT = "INSERT INTO " + getTableName() 
            + "(NUM_REGISTRO,"
            + "FECHA_ENTRADA,"
            + "FECHA_SALIDA"
            + ",USUARIO_TIPO_DOCUMENTO,"
            + "USUARIO_NUM_DOCUMENTO,"
            + "ROL_REGISTRO,"
            + "MOTIVO_VISITA)"
            + " VALUES "
            + "(?,?,?,?,?,?,?);";

    private final String SQL_UPDATE = "UPDATE " + getTableName() 
            + " SET FECHA_ENTRADA = ?,"
            + "FECHA_SALIDA= ?,"
            + "ROL_REGISTRO= ?,"
            + "MOTIVO_VISITA= ? "
            + "WHERE NUM_REGISTRO = ? ;";

    private final String SQL_DELETE = "DELETE FROM " + getTableName() + " where NUM_REGISTRO = ? ;";

    private final String SQL_COUNT = "select count(*) from " + getTableName() + ";";

    public List<Registro> findAll() {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Registro> lt = new ArrayList<>();

        try {

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

            // construct the SQL statement
            final String SQL = SQL_SELECT;

            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            rs = stmt.executeQuery();

            if (!rs.wasNull()) {
                while (rs.next()) {
                    Registro r = new Registro();
                    r.setNumRegistro(rs.getInt(1));
                    r.setFechaEntrada(rs.getTimestamp(2));
                    r.setFechaSalida(rs.getTimestamp(3));
                    r.setUsuarioTipoDocumento(rs.getString(4));
                    r.setUsuarioNumDocumento(rs.getString(5));
                    r.setRolRegistro(rs.getString(6));
                    r.setMotivoVisita(rs.getString(7));

                    lt.add(r);
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

    @Override
    public void insert(Registro dto) {
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

            // construct the SQL statement
            final String SQL = SQL_INSERT;
            int indice = 1;
            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(indice++, dto.getNumRegistro());
            stmt.setTimestamp(indice++, dto.getFechaEntrada());
            stmt.setTimestamp(indice++, dto.getFechaSalida());
            stmt.setString(indice++, dto.getUsuarioTipoDocumento());
            stmt.setString(indice++, dto.getUsuarioNumDocumento());
            stmt.setString(indice++, dto.getRolRegistro());
            stmt.setString(indice++, dto.getMotivoVisita());

            rs = stmt.executeUpdate();

        } catch (Exception _e) {
            System.out.println("error en el findAll" + _e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }
    }

    @Override
    public void update(RegistroPK llaveDto, Registro dto) {
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

            // construct the SQL statement
            final String SQL = SQL_UPDATE;
            int indice = 1;
            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);

            stmt.setTimestamp(indice++, dto.getFechaEntrada());
            stmt.setTimestamp(indice++, dto.getFechaSalida());
            stmt.setString(indice++, dto.getRolRegistro());
            stmt.setString(indice++, dto.getMotivoVisita());
            stmt.setInt(indice++, llaveDto.getNumRegistro());

            rs = stmt.executeUpdate();

        } catch (Exception _e) {
            System.out.println("error en el findAll" + _e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }

    }

    @Override
    public void delete(RegistroPK dto) {

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

            // construct the SQL statement
            final String SQL = SQL_DELETE;
            int indice = 1;
            System.out.println("se ejecuto" + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setInt(indice++, dto.getNumRegistro());

            rs = stmt.executeUpdate();

        } catch (Exception _e) {
            System.out.println("error en el findAll"+_e.getMessage());
        } finally {
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }

    }

    @Override
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

    @Override
    public List<RegistroPK> findByPK() {
        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegistroPK> lt = new ArrayList<>();

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
                    RegistroPK r = new RegistroPK();
                    r.setNumRegistro(rs.getInt(1));

                    lt.add(r);
                }
            }

        } catch (Exception _e) {
            System.out.println("error en el findAll" + _e.getMessage());
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!estaConectado) {
                ResourceManager.close(conn);
            }
        }
        return lt;

    }

    public String getTableName() {
        return "adsistencia.registro";
    }
}

