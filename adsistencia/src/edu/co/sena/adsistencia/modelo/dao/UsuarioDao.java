/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dao;

import edu.co.sena.adsistencia.modelo.dto.Usuario;
import edu.co.sena.adsistencia.modelo.dto.UsuarioPK;
import java.util.List;

/**
 *
 * @author users
 */
public interface UsuarioDao {

    public List<Usuario> findAll();

    public void insert(Usuario dto);

    public void update(UsuarioPK llaveDto, Usuario dto);

    public void updatePk(UsuarioPK  viejo, UsuarioPK  nuevo);

    public void delete(UsuarioPK  dot);

    public List<UsuarioPK> findByPK();

    public int count();
}
