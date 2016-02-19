/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao;

import edu.co.sena.adsistencia.modelo.dto.PropietarioPK;
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipo;
import edu.co.sena.adsistencia.modelo.dto.RegistroEquipoPK;
import java.util.List;

/**
 *
 * @author users
 */
public interface RegistroEquipoDao {

    public List<RegistroEquipo> findAll();

    public void insert(RegistroEquipo dto);

    public void update(RegistroEquipoPK llaveDto, RegistroEquipo dto);

    public void delete(RegistroEquipoPK dto);

    public int count();

    public List<RegistroEquipoPK> findAllPK();

}
