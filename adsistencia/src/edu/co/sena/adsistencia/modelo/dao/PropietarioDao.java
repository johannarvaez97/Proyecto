/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao;

import edu.co.sena.adsistencia.modelo.dto.Propietario;
import edu.co.sena.adsistencia.modelo.dto.PropietarioPK;
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipoPK;
import java.util.List;

/**
 *
 * @author users
 */
public interface PropietarioDao {

    public List<Propietario> findAll();

    public void insert(Propietario dto);

    public void delete(PropietarioPK dto);

    public int count();

    public List<PropietarioPK> findAllPK();
}
