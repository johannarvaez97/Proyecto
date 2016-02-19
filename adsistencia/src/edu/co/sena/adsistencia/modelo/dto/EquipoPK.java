/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dto;

import java.io.Serializable;

/**
 *
 * @author users
 */
public class EquipoPK implements Serializable {

    private int idEquipo;

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public EquipoPK() {
    }

    public EquipoPK(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.adsistencia.dto.EquipoPk: ");
        ret.append("idEquipo=" + idEquipo);
        return ret.toString();
    }
}
