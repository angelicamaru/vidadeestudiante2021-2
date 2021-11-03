package com.spring.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.ResponseBody;

import com.entidades.Usuario;
import com.entidades.UsuarioMapper;
import com.spring.logicaNegocio.ModUsuario;
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ControllerUsuario {

	//Objetos
	ModUsuario Modelo=new ModUsuario();
	
	//Metodos
	
	/**
	 * Agregar un Usuario
	 * @param usuarioNuevo
	 * @return r (true si pudo agregar, false si ya existia un usuario con ese correo)
	 */
	@PostMapping("/addUsuario")
    boolean addUsuario(@RequestBody Usuario usuarioNuevo) {
        boolean r = this.Modelo.getValidacion(new UsuarioMapper(usuarioNuevo.getCorreo(), usuarioNuevo.getClave()));
        if (r) {
            this.Modelo.addUsuario(usuarioNuevo);
        }
        return r;
    }

	
	/**
	 * Valida correo y clave
	 * @param correo y clave
	 * @return boolean 
	 */
	@PostMapping("/LogUsuario")
	@ResponseBody
	boolean ValidaUsuario(@RequestBody UsuarioMapper user) {
		boolean p = this.Modelo.getUsuarioMapper(user);
		return p;
	}
}