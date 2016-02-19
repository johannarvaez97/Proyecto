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
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipo;

/**
 *
 * @author users
 */
public interface DaoFactory {

    public EquipoDao createEquipoDAO();

    public RegistroEquipoDao createRegistroEquipoDAO();

    public PropietarioDao createPropietarioDAO();

    public UsuarioDao createUsuarioDAO();

    public CuentaDao createCuentaDAO();

    public RegistroDao createRegistroDAO();
}
