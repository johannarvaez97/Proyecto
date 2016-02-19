/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author users
 */
public class Registro implements  Serializable{

    private int numRegistro;
    private Timestamp fechaEntrada;
    private Timestamp fechaSalida;
    private String usuarioTipoDocumento;
    private String usuarioNumDocumento;
    private String rolRegistro;
    private String motivoVisita;

    public Registro() {
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
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

    public String getRolRegistro() {
        return rolRegistro;
    }

    public void setRolRegistro(String rolRegistro) {
        this.rolRegistro = rolRegistro;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    @Override
    public String toString() {

        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.proyectov2.dto: ");
        ret.append("numRegistro :" + numRegistro);
        ret.append("fechaEntrada:" + fechaEntrada);
        ret.append("fechaSalida:" + fechaSalida);

        ret.append("usuarioTipoDocumento:" + usuarioTipoDocumento);
        ret.append("usuarioNumDocumento:" + usuarioNumDocumento);
        ret.append("rolRegistro:" + rolRegistro);
        ret.append("motivoVisita" + motivoVisita);
        return ret.toString();
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
}
