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
public class Equipo implements Serializable {

    private int idEquipo;
    private String marcacuenta;
    private String numSerial;
    private String descripcion;

    public Equipo() {
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getMarca() {
        return marcacuenta;
    }

    public void setMarca(String marca) {
        this.marcacuenta = marcacuenta;
    }

    public String getNumSerial() {
        return numSerial;
    }

    public void setNumSerial(String numSerial) {
        this.numSerial = numSerial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.adsistencia.dto.Equipo :  ");
        ret.append("idEquipo=" + idEquipo);
        ret.append(", marcacuenta=" + marcacuenta);
        ret.append(",numSerial=" + numSerial);
        ret.append(",descripcion=" + descripcion);
        return ret.toString();
    }
}
