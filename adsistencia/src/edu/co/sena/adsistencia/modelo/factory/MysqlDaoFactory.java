/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.factory;

import edu.co.sena.adsistencia.modelo.dao.CuentaDao;
import edu.co.sena.adsistencia.modelo.dao.EquipoDao;
import edu.co.sena.adsistencia.modelo.dao.PropietarioDao;
import edu.co.sena.adsistencia.modelo.dao.RegistroDao;
import edu.co.sena.adsistencia.modelo.dao.RegistroEquipoDao;
import edu.co.sena.adsistencia.modelo.dao.UsuarioDao;
import edu.co.sena.adsistencia.modelo.dao.mysql.CuentaDaoImpl;
import edu.co.sena.adsistencia.modelo.dao.mysql.EquipoDaoImpl;
import edu.co.sena.adsistencia.modelo.dao.mysql.PropietarioDaoImpl;
import edu.co.sena.adsistencia.modelo.dao.mysql.RegistroDaoImpl;
import edu.co.sena.adsistencia.modelo.dao.mysql.RegistroEquipoDaoImpl;
import edu.co.sena.adsistencia.modelo.dao.mysql.UsuarioDaoImpl;

/**
 *
 * @author users
 */
public class MysqlDaoFactory extends DaoAbstractFactory {

    @Override
    public EquipoDao createEquipoDAO() {
        return new EquipoDaoImpl();
    }

    @Override
    public RegistroEquipoDao createRegistroEquipoDAO() {
        return new RegistroEquipoDaoImpl();
    }

    @Override
    public PropietarioDao createPropietarioDAO() {
        return new PropietarioDaoImpl();
    }

    
    @Override
    public UsuarioDao createUsuarioDAO() {
        return new UsuarioDaoImpl();
    }

    @Override
    public CuentaDao createCuentaDAO() {

        return new CuentaDaoImpl();
    }

    @Override
    public RegistroDao createRegistroDAO() {
        return new RegistroDaoImpl();

    }
    
}
