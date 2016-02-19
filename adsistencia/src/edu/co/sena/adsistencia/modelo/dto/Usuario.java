/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dto;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 *
 * @author users
 */
public class Usuario implements Serializable {

    private String tipoDocumento;
    private String numDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String perfil;
    private Timestamp fechaVencimiento;
    private boolean estado;
    private Blob foto;

    public Usuario() {
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

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }



    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Timestamp getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Timestamp fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob  foto) {
        this.foto = foto;
    }
    
    

    @Override
    public String toString() {

        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.proyectov2.dao: ");
        ret.append("tipoDocumento=" + tipoDocumento);
        ret.append(", numDocumento=" + numDocumento);
        ret.append(", primerNombre=" + primerNombre);
        ret.append(", segundoNombre=" + segundoNombre);
        ret.append(", primerApellido=" + primerApellido);
        ret.append(", segundoApellido=" + segundoApellido);
        ret.append(", perfil=" + perfil);
        ret.append(", fechaVencimiento=" + fechaVencimiento);
        ret.append(", estado=" + estado);
        ret.append(", foto=" + foto);
        return ret.toString();

    }

    

}
