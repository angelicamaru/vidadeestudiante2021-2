package com.entidades;


public class Usuario {

    private String id;
	private String nombre;
	private String correo;
    private String clave;
	
	public Usuario() {
        this.id = "";
		this.nombre = "";
		this.correo = "";
		this.clave = "";
	}

	
	public Usuario (String id, String nombre, String correo, String clave) { 
        this.id = id;
		this.nombre = nombre;
        this.correo = correo;
		this.clave = clave;
	}

    public String getId() {
        return id;
    }

    public void setId (String id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

	
}
