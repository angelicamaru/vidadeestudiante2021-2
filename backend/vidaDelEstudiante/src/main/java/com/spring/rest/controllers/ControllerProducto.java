package com.spring.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Producto;
import com.spring.logicaNegocio.ModProducto;
import com.spring.logicaNegocio.ModProductos;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ControllerProducto {
	
	//Objetos
	ModProducto producto = new ModProducto();
        ModProductos productos = new ModProductos();
	
	//Añadir producto	
	@PostMapping("/addProducto")
	Producto addProducto(@RequestBody Producto productoNuevo) {
		producto.addProducto(productoNuevo);
		 return productoNuevo;
		 
	}
	
	//Añadir producto	
		@PostMapping("/getProducto")
		Producto getProducto(@RequestBody String id) {
			Producto proS = producto.getProducto(id);
			 return proS;
		}
	//Añadir Productos	
	@PostMapping("/getProductos")
        ArrayList traeProductos() {
        ArrayList all = productos.getProductos();
        return all;
    }
	
}
