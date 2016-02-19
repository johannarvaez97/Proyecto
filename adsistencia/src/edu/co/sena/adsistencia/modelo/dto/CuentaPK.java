/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dto;

import java.io.Serializable;

/**
 *
 * @author users
 */
public class CuentaPK implements Serializable{
     private String usuarioTipoDocumento;
    private String usuarioNumDocumento;

    public CuentaPK() {
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

    public CuentaPK(String usuarioTipoDocumento, String usuarioNumDocumento) {
        this.usuarioTipoDocumento = usuarioTipoDocumento;
        this.usuarioNumDocumento = usuarioNumDocumento;
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.proyectov2.dao.CuentaPK: ");
        ret.append("usuarioTipoDocumento=" + usuarioTipoDocumento);
        ret.append(",usuarioNumDocumento=" + usuarioNumDocumento);
        return ret.toString();
    }
}
