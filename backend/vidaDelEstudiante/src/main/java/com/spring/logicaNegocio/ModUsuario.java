package com.spring.logicaNegocio;

import org.springframework.stereotype.Service;

import com.entidades.Usuario;
import com.entidades.UsuarioMapper;
import basededatos.ConexionUsuario;

@Service
public class ModUsuario {

	/**
	 * Objetos
	 */
	UsuarioMapper UsuarioM = new UsuarioMapper();
	ConexionUsuario con;

	// Metodos
	
	/**
	 * Agregar un Usuario
	 * @param usuarioNuevo
	 */
	public void addUsuario(Usuario usuarioNuevo) {
		con = new ConexionUsuario();
		con.usuarioNuevo(usuarioNuevo);
		con.desconectar();
	}

	/**
	 * Validar clave y correo
	 * 
	 * @param UsuarioRecibido tipo UsuarioMapper
	 * @return boolean que dice si existe ese usuario con clave y correo correctos
	 */
	public boolean getUsuarioMapper(UsuarioMapper UsuarioRecibido) {
		con = new ConexionUsuario();
		UsuarioMapper usuario = con.getUsuarioMapper(UsuarioRecibido);
		if (usuario != null) {
			con.desconectar();
			return true;
		}
		return false;
	}

	public boolean getValidacion(UsuarioMapper UsuarioRecibido) {
		con = new ConexionUsuario();
		UsuarioMapper usuario = con.getUsuario(UsuarioRecibido.getCorreo());
		if (usuario != null) {
			// Dame false si el usuario si existe
			con.desconectar();
			return false;
		}
		// Dame true si el usuario no existe es decir si añade
		return true;
	}

}
