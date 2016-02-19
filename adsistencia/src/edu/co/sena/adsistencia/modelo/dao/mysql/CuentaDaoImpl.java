/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao.mysql;

import edu.co.sena.adsistencia.modelo.dao.CuentaDao;
import edu.co.sena.adsistencia.modelo.dto.Cuenta;
import edu.co.sena.adsistencia.modelo.dto.CuentaPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author users
 */
public class CuentaDaoImpl implements CuentaDao {

    private Connection conexion;

    private final String SQL_SELECT = "select * from " + getTableName() + "";

    private final String SQL_INSERT = "INSERT INTO " + getTableName()
            + "(CONTRASENA,"
            + "ROL,"
            + "USUARIO_TIPO_DOCUMENTO,"
            + "USUARIO_NUM_DOCUMENTO,"
            + "CORREO_ELECTRONICO)"
            + " VALUES "
            + "(?,?,?,?,?)";

    private final String SQL_UPDATE = "UPDATE " + getTableName()
            + " SET CONTRASENA = ?,"
            + "ROL = ?,"
            + "CORREO_ELECTRONIC0O = ?"
            + " WHERE USUARIO_TIPO_DOCUMENTO = ? "
            + "AND USUARIO_NUM_DOCUMENTO = ? ;";

    private final String SQL_DELETE = "DELETE FROM " + getTableName() 
            + " WHERE USUARIO_TIPO_DOCUMENTO = ?"
            + " AND USUARIO_NUM_DOCUMENTO = ? ;";

    private final String SQL_COUNT = "select count(*) from " + getTableName() + ";";

    @Override
    public List<Cuenta> findAll() {

        final boolean conectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cuenta> lt = new ArrayList<>();

        try {

            if (conectado) {
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
                    Cuenta c = new Cuenta();
                    c.setContrasena(rs.getString(1));
                    c.setRol(rs.getString(2));
                    c.setUsuarioTipoDocumento(rs.getString(3));
                    c.setUsuarioNumDocumento(rs.getString(4));
                    c.setCorreoElectronico(rs.getString(5));
                    lt.add(c);
                }
            }

        } catch (Exception _e) {
            System.out.println("error en el findAll");
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!conectado) {
                ResourceManager.close(conn);
            }
        }
        return lt;
    }

    @Override
    public void insert(Cuenta dto) {
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
            stmt.setString(indice++, dto.getContrasena());
            stmt.setString(indice++, dto.getRol());
            stmt.setString(indice++, dto.getUsuarioTipoDocumento());
            stmt.setString(indice++, dto.getUsuarioNumDocumento());
            stmt.setString(indice++, dto.getCorreoElectronico());

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

    public void update(CuentaPK llaveDto, Cuenta dto) {

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
            stmt.setString(indice++, dto.getContrasena());
            stmt.setString(indice++, dto.getRol());
            stmt.setString(indice++, dto.getCorreoElectronico());
            stmt.setString(indice++, llaveDto.getUsuarioTipoDocumento());
            stmt.setString(indice++, llaveDto.getUsuarioNumDocumento());

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
    public void delete(CuentaPK dto) {

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
            stmt.setString(indice++, dto.getUsuarioTipoDocumento());
            stmt.setString(indice++, dto.getUsuarioNumDocumento());

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
    public List<CuentaPK> findByPK() {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CuentaPK> lt = new ArrayList<>();

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
                    CuentaPK c = new CuentaPK();
                    c.setUsuarioTipoDocumento(rs.getString(3));
                    c.setUsuarioNumDocumento(rs.getString(4));

                    lt.add(c);
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
        return "adsistencia.cuenta";
    }
}
