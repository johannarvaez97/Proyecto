/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao;

import edu.co.sena.adsistencia.modelo.dto.Cuenta;
import edu.co.sena.adsistencia.modelo.dto.CuentaPK;
import java.util.List;

/**
 *
 * @author users
 */
public interface CuentaDao {
    public List<Cuenta> findAll();

    public void insert(Cuenta dto);

    public void update(CuentaPK llaveDto, Cuenta dto); 

    public void delete(CuentaPK   dto);

    public List<CuentaPK> findByPK();

    public int count();
}
