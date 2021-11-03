package com.spring.rest.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Blog;
import com.entidades.BlogMapper;
import com.spring.logicaNegocio.ModBlog;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ControllerBlog {
	
	//Objetos
	ModBlog blog = new ModBlog();
	
	//Añadir Blog	
	@PostMapping("/addBlog")
	void addBlog(@RequestBody Blog BlogNuevo) {
		blog.addBlog(BlogNuevo);
	}
	
	//Traer Blog
	@PostMapping("/getBlog")
	Blog getBlog(@RequestBody String titulo ) {
		Blog blogSol = blog.getBlog(titulo);
		return blogSol;
	}
	
	//Traer Blogs
	@PostMapping("/getBlogs")
		ArrayList<BlogMapper> getBlogs () {
			ArrayList<BlogMapper> blogsSol = blog.getBlogs();
			return blogsSol;
		}
	
	
	
}
	
	 
    

	