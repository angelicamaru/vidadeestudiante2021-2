package com.entidades;

public class Blog {

	private int idBlog;
	private String titulo;
	private String imagen;
	private String descripcion;
	private String autor;
	private String fecha;
	private String etiquetaUno;
	private String etiquetaDos;
	
	
	public Blog(int idBlog, String titulo, String imagen, String descripcion, String autor, String fecha, String etiquetaUno, String etiquetaDos) {
		super();
		this.idBlog = idBlog;
		this.titulo = titulo;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha = fecha;
		this.etiquetaUno = etiquetaUno;
		this.etiquetaDos = etiquetaDos;
	}
	
	public Blog() {
		super();
		this.idBlog = 0;
		this.titulo = "";
		this.imagen = "";
		this.descripcion = "";
		this.autor = "";
		this.fecha = "";
		this.etiquetaUno = "";
		this.etiquetaDos = "";
	}

	public int getIdBlog() {
		return idBlog;
	}

	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEtiquetaUno() {
		return etiquetaUno;
	}

	public void setEtiquetaUno(String etiquetaUno) {
		this.etiquetaUno = etiquetaUno;
	}

	public String getEtiquetaDos() {
		return etiquetaDos;
	}

	public void setEtiquetaDos(String etiquetaDos) {
		this.etiquetaDos = etiquetaDos;
	}


	
	
	
}
