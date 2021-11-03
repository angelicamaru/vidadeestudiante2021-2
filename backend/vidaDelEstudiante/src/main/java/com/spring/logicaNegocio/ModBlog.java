package com.spring.logicaNegocio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.entidades.Blog;
import com.entidades.BlogMapper;

import basededatos.ConexionBlog;


@Service
public class ModBlog {
	
	//Objetos
	Blog Blog = new Blog();
	ConexionBlog con;

	//Métodos
	
	//Añadir Blog
	public void addBlog(Blog BlogNuevo) {
		con = new ConexionBlog();
	    con.BlogNuevo(BlogNuevo);
	    con.desconectar();
		
	}

	//Traer Blog
	public Blog getBlog(String titulo) {
		con = new ConexionBlog();
	    Blog blogS = con.traerBlog(titulo);
	    con.desconectar();
		return blogS;
	}
	
	//Traer Blogs
		public ArrayList<BlogMapper> getBlogs() {
			con = new ConexionBlog();
			ArrayList<BlogMapper> blogsS = con.traerBlogs();
		    con.desconectar();
			return blogsS;
		}
}
