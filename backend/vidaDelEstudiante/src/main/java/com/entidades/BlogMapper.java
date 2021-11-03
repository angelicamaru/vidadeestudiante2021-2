package com.entidades;

public class BlogMapper {

	private int idBlog;
	private String titulo;
	private String imagen;
	
	public BlogMapper(int idBlog, String titulo, String imagen) {
	
		this.idBlog = idBlog;
		this.titulo = titulo;
		this.imagen = imagen;
	}
	
	public BlogMapper() {
		this.idBlog = 0;
		this.titulo = "";
		this.imagen = "";
		
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
	
	
	
}
