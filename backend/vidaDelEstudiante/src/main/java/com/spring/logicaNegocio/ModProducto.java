package com.spring.logicaNegocio;

import org.springframework.stereotype.Service;

import com.entidades.Producto;

import basededatos.ConexionProducto;

@Service
public class ModProducto {
	
	//Objetos
	Producto producto = new Producto();
	ConexionProducto con;

	//Métodos
	
	//Añadir producto
	public void addProducto(Producto productoNuevo) {
		con = new ConexionProducto();
	    con.productoNuevo(productoNuevo);
	    con.desconectar();
		
	}
	
	//Traer producto
		public Producto getProducto(String id) {
			con = new ConexionProducto();
		    Producto prodS = con.traerProducto(id);
		    con.desconectar();
		   
		    return prodS;
			
		}
}
