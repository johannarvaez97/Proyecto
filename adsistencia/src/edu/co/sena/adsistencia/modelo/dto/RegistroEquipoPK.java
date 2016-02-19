/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.adsistencia.modelo.dto;

/**
 *
 * @author users
 */
public class RegistroEquipoPK {
    private int RegistroNumRegistro;
    private int PropietarioEquipoIdEquipo;
    private String PropietarioUsuarioTipoDocumento;
    private String PropietarioUsuarioNumDocumento;

    public RegistroEquipoPK() {
    }

    public int getRegistroNumRegistro() {
        return RegistroNumRegistro;
    }

    public void setRegistroNumRegistro(int RegistroNumRegistro) {
        this.RegistroNumRegistro = RegistroNumRegistro;
    }

    public int getPropietarioEquipoIdEquipo() {
        return PropietarioEquipoIdEquipo;
    }

    public void setPropietarioEquipoIdEquipo(int PropietarioEquipoIdEquipo) {
        this.PropietarioEquipoIdEquipo = PropietarioEquipoIdEquipo;
    }

    public String getPropietarioUsuarioTipoDocumento() {
        return PropietarioUsuarioTipoDocumento;
    }

    public void setPropietarioUsuarioTipoDocumento(String PropietarioUsuarioTipoDocumento) {
        this.PropietarioUsuarioTipoDocumento = PropietarioUsuarioTipoDocumento;
    }

    public String getPropietarioUsuarioNumDocumento() {
        return PropietarioUsuarioNumDocumento;
    }

    public void setPropietarioUsuarioNumDocumento(String PropietarioUsuarioNumDocumento) {
        this.PropietarioUsuarioNumDocumento = PropietarioUsuarioNumDocumento;
    }

    public RegistroEquipoPK(int RegistroNumRegistro, int PropietarioEquipoIdEquipo, String PropietarioUsuarioTipoDocumento, String PropietarioUsuarioNumDocumento) {
        this.RegistroNumRegistro = RegistroNumRegistro;
        this.PropietarioEquipoIdEquipo = PropietarioEquipoIdEquipo;
        this.PropietarioUsuarioTipoDocumento = PropietarioUsuarioTipoDocumento;
        this.PropietarioUsuarioNumDocumento = PropietarioUsuarioNumDocumento;
    }
    
    
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "edu.co.sena.adsistencia.dto.registroequipo: " );
		ret.append( "id requistro equipo=" +RegistroNumRegistro );
		ret.append( "tipo documento =" +PropietarioUsuarioTipoDocumento );
		ret.append( "numero documento =" +PropietarioUsuarioNumDocumento);
		ret.append( "id equipo =" +PropietarioEquipoIdEquipo);
		return ret.toString();
	}

}
