package com.spring.logicaNegocio;

import org.springframework.stereotype.Service;

import com.entidades.Evento;

import basededatos.ConexionEvento;

@Service
public class ModEvento {

	// Atributos
	ConexionEvento con;

	// Metodos
	/**
	 * Llama a conexion para agregar evento a BD después de validar si hay un evento
	 * con datos iguales.
	 * 
	 * @param elEvento
	 */
	public boolean addEvento(Evento elEvento) {
		int valida = 0;
		this.con = new ConexionEvento();
		if (!con.validaEvento(elEvento)) {
			this.con.desconectar();
			return false;
		} else {
			valida = con.addEvent(elEvento);
			// 1292 es el numero de error que produce la BD cuando fecha esta vacío
			if (valida == 1292) {
				this.con.desconectar();
				return false;
			}
		}
		this.con.desconectar();
		return true;
	}

	/**
	 * @return arreglo con todos Eventos
	 */
	public Evento[] getEventos() {
		Evento[] eventos;
		this.con = new ConexionEvento();
		eventos = this.con.getEventos();
		return eventos;
	}
}
