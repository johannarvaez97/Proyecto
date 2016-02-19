/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao;

import edu.co.sena.adsistencia.modelo.dto.Registro;
import edu.co.sena.adsistencia.modelo.dto.RegistroPK;
import java.util.List;

/**
 *
 * @author users
 */
public interface RegistroDao {

    public List<Registro> findAll();

    public void insert(Registro dto);

    public void update(RegistroPK llaveDto, Registro dto);

    public void delete(RegistroPK dto);

    public List<RegistroPK> findByPK();

    public int count();
}