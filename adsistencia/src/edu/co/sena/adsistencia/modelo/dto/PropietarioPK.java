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
public class PropietarioPK implements Serializable {

    private String usuarioTipoDocumento;
    private String usuarioNumDocumento;
    private String equipoIdEquipo;

    public PropietarioPK() {
    }

    public PropietarioPK(String usuarioTipoDocumento, String usuarioNumDocumento, String equipoIdEquipo) {
        this.usuarioTipoDocumento = usuarioTipoDocumento;
        this.usuarioNumDocumento = usuarioNumDocumento;
        this.equipoIdEquipo = equipoIdEquipo;
    }
    
    

    public PropietarioPK(String numDocumento) {
        this.usuarioNumDocumento = numDocumento;
    }

    public String getUsuarioNumDocumento() {
        return usuarioNumDocumento;
    }

    public void setUsuarioNumDocumento(String usuarioNumDocumento) {
        this.usuarioNumDocumento = usuarioNumDocumento;
    }

    public String getUsuarioTipoDocumento() {
        return usuarioTipoDocumento;
    }

    public void setUsuarioTipoDocumento(String usuarioTipoDocumento) {
        this.usuarioTipoDocumento = usuarioTipoDocumento;
    }

    public String getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(String equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.adsistencia.dto.PropietarioPk: ");
        ret.append("Tipo documento=" + usuarioTipoDocumento);
        ret.append("numero documento=" + usuarioNumDocumento);
        ret.append("equipo id =" + usuarioTipoDocumento);
        return ret.toString();
    }
}
