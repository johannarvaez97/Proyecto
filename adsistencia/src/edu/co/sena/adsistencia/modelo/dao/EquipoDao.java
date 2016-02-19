/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao;

import edu.co.sena.adsistencia.modelo.dto.Equipo;
import edu.co.sena.adsistencia.modelo.dto.EquipoPK;
import java.util.List;

/**
 *
 * @author users
 */
public interface EquipoDao {

    public List<Equipo> findAll();

    public void insert(Equipo dto);

    public void update(EquipoPK llaveDto, Equipo dto);

    public void updatePk(EquipoPK viejo, EquipoPK nuevo);
    public void delete(EquipoPK dto);
    
       public int count();
         public List<EquipoPK> findAllPK();
}
