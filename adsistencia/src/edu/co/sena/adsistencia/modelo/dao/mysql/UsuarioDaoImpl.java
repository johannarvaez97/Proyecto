/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao.mysql;

import edu.co.sena.adsistencia.modelo.dao.UsuarioDao;
import edu.co.sena.adsistencia.modelo.dto.Usuario;
import edu.co.sena.adsistencia.modelo.dto.UsuarioPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author users
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection conexion;
    private final String SQL_SELECT = "select * from " + getTableName() + "";

    private final String SQL_INSERT = "INSERT INTO "+ getTableName()
            +"(TIPO_DOCUMENTO,"
            +"NUM_DOCUMENTO,"
            +"PRIMER_NOMBRE,"
            +"SEGUNDO_NOMBRE,"
            +"PRIMER_APELLIDO,"
            +"SEGUNDO_APELLIDO,"
            +"PERFIL,"
            +"FECHA_VENCIMIENTO,"
            +"ESTADO,"
            +"FOTO)"
            +"VALUES"
            +"(?,?,?,?,?,?,?,?,?,?);";

    private final String SQL_UPDATE = "UPDATE " + getTableName() +
            " SET PRIMER_NOMBRE= ?,"
            + "SEGUNDO_NOMBRE= ?,"
            +"PRIMER_APELLIDO= ?,"
            + "SEGUNDO_APELLIDO= ?,\n"
            +"PERFIL= ?,"
            + "FECHA_VENCIMIENTO= ?,"
            + "ESTADO= ?,"
            + "FOTO= ? "
            + "WHERE TIPO_DOCUMENTO = ? "
            + "AND NUM_DOCUMENTO = ? ;";

    private final String SQL_UPDATEPK = "UPDATE " + getTableName() + " SET  TIPO_DOCUMENTO =? , NUM_DOCUMENTO=? where TIPO_DOCUMENTO=? AND NUM_DOCUMENTO=?;";

    private final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE TIPO_DOCUMENTO = ? AND NUM_DOCUMENTO = ? ;";

    private final String SQL_COUNT = "select count(*) from "+getTableName();

    @Override
    public List<Usuario> findAll() {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> lt = new ArrayList<>();

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
                    Usuario u = new Usuario();
                    u.setTipoDocumento(rs.getString(1));
                    u.setNumDocumento(rs.getString(2));
                    u.setPrimerNombre(rs.getString(3));
                    u.setSegundoNombre(rs.getString(4));
                    u.setPrimerApellido(rs.getString(5));
                    u.setSegundoApellido(rs.getString(6));
                    u.setPerfil(rs.getString(7));
                    u.setFechaVencimiento(rs.getTimestamp(8));
                    u.setEstado(rs.getBoolean(9));
                    u.setFoto(rs.getBlob(10));
                    lt.add(u);
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

    @Override
    public void insert(Usuario dto) {

        final boolean estaConectado = (conexion != null);
         Connection conn = null;
        PreparedStatement stmt = null;
        int rs;

        try {

            if (estaConectado) {
                conn = conexion;
            }
             else {
                conn = ResourceManager.getConection();
            }

            final String SQL = SQL_INSERT;
            int indice = 1;
            System.out.println("Se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setString(indice++, dto.getTipoDocumento());
            stmt.setString(indice++, dto.getNumDocumento());
            stmt.setString(indice++, dto.getPrimerNombre());
            stmt.setString(indice++, dto.getSegundoNombre());
            stmt.setString(indice++, dto.getPrimerApellido());
            stmt.setString(indice++, dto.getSegundoApellido());
            stmt.setString(indice++, dto.getPerfil());
            stmt.setTimestamp(indice++, dto.getFechaVencimiento());
            stmt.setBoolean(indice++, dto.getEstado());
            stmt.setBlob(indice++, dto.getFoto());

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
    public void update(UsuarioPK llaveDto, Usuario dto) {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs;

        try {
            // obtener el la conexion 

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
            stmt.setString(indice++, dto.getPrimerNombre());
            stmt.setString(indice++, dto.getSegundoNombre());
            stmt.setString(indice++, dto.getPrimerApellido());
            stmt.setString(indice++, dto.getSegundoApellido());
            stmt.setString(indice++, dto.getPerfil());
            stmt.setTimestamp(indice++, dto.getFechaVencimiento());
            stmt.setBoolean(indice++, dto.getEstado());
            stmt.setBlob(indice++, dto.getFoto());
            stmt.setString(indice++, llaveDto.getTipoDocumento());
            stmt.setString(indice++, llaveDto.getNumDocumento());

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
    public void delete(UsuarioPK dto) {

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
            System.out.println("Se ejecuto" + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setString(indice++, dto.getTipoDocumento());
            stmt.setString(indice++, dto.getNumDocumento());

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
    public void updatePk(UsuarioPK viejo, UsuarioPK nuevo) {
        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        int rs;

        try {
            // obtener el la conexion 

            if (estaConectado) {
                conn = conexion;
            } else {
                conn = ResourceManager.getConection();
            }

            // construct the SQL statement
            final String SQL = SQL_UPDATEPK;
            int indice = 1;
            System.out.println("se ejecuto " + SQL);
            stmt = conn.prepareStatement(SQL);
            stmt.setString(indice++, nuevo.getTipoDocumento());
            stmt.setString(indice++, nuevo.getNumDocumento());
            stmt.setString(indice++, viejo.getTipoDocumento());
            stmt.setString(indice++, viejo.getNumDocumento());

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

  

    @Override
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

    @Override
    public List<UsuarioPK> findByPK() {

        final boolean estaConectado = (conexion != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UsuarioPK> lt = new ArrayList<>();

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
                    UsuarioPK u = new UsuarioPK();
                    u.setTipoDocumento(rs.getString(1));
                    u.setNumDocumento(rs.getString(2));
                    lt.add(u);
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
        return "adsistencia.usuario";
    }

}