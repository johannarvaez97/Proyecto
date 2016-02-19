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
public class Cuenta  implements  Serializable{
    private String contrasena;
    private String rol;
    private String correoElectronic0o;
    private String usuarioTipoDocumento;
    private String usuarioNumDocumento;

    public Cuenta() {
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreoElectronico() {
        return correoElectronic0o;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronic0o = correoElectronico;
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

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.proyectov2.dao: ");
        ret.append("contrasena=" + contrasena);
        ret.append(", rol=" + rol);
        ret.append(", correoElectronico=" + correoElectronic0o);
        ret.append(", usuarioTipoDocumento=" + usuarioTipoDocumento);
        ret.append(", usuarioNumDocumento=" + usuarioNumDocumento);

        return ret.toString();
    }   
}
