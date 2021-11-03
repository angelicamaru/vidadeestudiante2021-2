package com.entidades;


public class Producto {

	private float precio;
	private int idProducto;
	private String imagen;
	private String nombre;
	private String descripcion;
	private int numeroDisponible;
	
	
	
	public Producto() {
		this.precio = 0;
		this.idProducto = 0;
		this.imagen = "";
		this.nombre = "";
		this.descripcion = "";
		this.numeroDisponible = 0;
	}
	
	public Producto(float precio, int idProducto, String imagen, String nombre, String descripcion, int numeroDisponible) {
		this.precio = precio;
		this.idProducto = idProducto;
		this.imagen = imagen;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroDisponible = numeroDisponible;
	}
	
	

	public int getNumeroDisponible() {
		return numeroDisponible;
	}

	public void setNumeroDisponible(int numeroDisponible) {
		this.numeroDisponible = numeroDisponible;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
	public String getImagen() {
		return imagen;
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
