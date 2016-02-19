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
public class RegistroPK implements Serializable{

 private int numRegistro;

    public RegistroPK() {
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public RegistroPK(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("edu.co.sena.proyectov2.dto.RegistroPK:");
        ret.append("numRegistro: "+numRegistro);
        return ret.toString();
    }
 
 
    
    
    
    

}