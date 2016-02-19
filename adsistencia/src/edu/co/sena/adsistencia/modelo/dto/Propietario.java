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
public class Propietario  implements Serializable{

    private String usuarioTipoDocumento;
    private String usuarioNumDocumento;
    private String equipoIdEquipo;

    public Propietario() {
    }

    public String getUsuarioTipoDocumento() {
        return usuarioTipoDocumento;
    }

    public void setUsuarioTipoDocumento(String usuarioTipoDocumento) {
        this.usuarioTipoDocumento = usuarioTipoDocumento;
    }

    public String getUsuarioNumDocumento() {
        return usuarioNumDocumento;
    }

    public void setUsuarioNumDocumento(String usuarioNumDocumento) {
        this.usuarioNumDocumento = usuarioNumDocumento;
    }

    public String getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(String equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.adsistencia.dto.propietario :  ");
        ret.append("usuario tipo documento=" + usuarioTipoDocumento);
        ret.append(", usuario numero documento =" + usuarioNumDocumento);
        ret.append(",equipo id equipo =" + equipoIdEquipo);
        return ret.toString();
    }
}
