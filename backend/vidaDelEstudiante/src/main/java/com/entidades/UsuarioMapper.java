package com.entidades;

public class UsuarioMapper {

	private String Correo;
	private String Clave;

	public UsuarioMapper() {
		Correo = "";
		Clave = "";
	}

	public UsuarioMapper(String correo, String clave) {
		super();
		Correo = correo;
		Clave = clave;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

}
