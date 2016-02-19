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
public class UsuarioPK implements Serializable {

    private String tipoDocumento;
    private String numDocumento;

    public UsuarioPK() {
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public UsuarioPK(String tipoDocumento, String numDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.proyectov2.dao.UsuarioPK: ");
        ret.append("tipoDocumento=" + tipoDocumento);
        ret.append(", numDocumento=" + numDocumento);
        return ret.toString();
    }

}

