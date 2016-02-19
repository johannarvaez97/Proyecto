/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import java.util.Date;

/**
 *
 * @author users
 */
public class RegistroEquipo implements Serializable {

    private int registroNumRegistro;
    private int propietarioEquipoIdEquipo;
    private String propietarioTipoDocumento;
    private String propietarioUsuarioNumDocumento;
    private Timestamp fechaEntrada;
    private Timestamp fechaSalida;

    public int getRegistroNumRegistro() {
        return registroNumRegistro;
    }

    public void setRegistroNumRegistro(int registroNumRegistro) {
        this.registroNumRegistro = registroNumRegistro;
    }

    public int getPropietarioEquipoIdEquipo() {
        return propietarioEquipoIdEquipo;
    }

    public void setPropietarioEquipoIdEquipo(int propietarioEquipoIdEquipo) {
        this.propietarioEquipoIdEquipo = propietarioEquipoIdEquipo;
    }

    public String getPropietarioTipoDocumento() {
        return propietarioTipoDocumento;
    }

    public void setPropietarioTipoDocumento(String propietarioTipoDocumento) {
        this.propietarioTipoDocumento = propietarioTipoDocumento;
    }

    public String getPropietarioUsuarioNumDocumento() {
        return propietarioUsuarioNumDocumento;
    }

    public void setPropietarioUsuarioNumDocumento(String propietarioUsuarioNumDocumento) {
        this.propietarioUsuarioNumDocumento = propietarioUsuarioNumDocumento;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public RegistroEquipo() {
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.adsistencia.dto.RegistroEquipo: ");
        ret.append("Registro numero registro=" + registroNumRegistro);
        ret.append(", propietario equipo id equipo =" + propietarioEquipoIdEquipo);
        ret.append(", propietario usuario tipo documento=" + propietarioTipoDocumento);
        ret.append(", propietario usuario numero documento =" + propietarioUsuarioNumDocumento);
        ret.append(", fecha entrada =" + fechaEntrada);
        ret.append(", fecha salida =" + fechaSalida);
        return ret.toString();
    }

    void setFechaEntrada(Calendar c1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
