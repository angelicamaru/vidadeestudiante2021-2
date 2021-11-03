package com.entidades;


public class Productos {

	private float precio;
	private int idProducto;
	private String imagen;
	private String nombre;
	private String descripcion;
	
	
	public Productos() {
            
       	this.idProducto = 0;
        this.nombre = "";
    	this.descripcion = "";
		this.precio = 0;
		this.imagen = "";
		
	}
	
	public Productos(int idProducto, String nombre, String descripcion, float precio , String imagen ) {
            
                this.idProducto = idProducto;
                this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
