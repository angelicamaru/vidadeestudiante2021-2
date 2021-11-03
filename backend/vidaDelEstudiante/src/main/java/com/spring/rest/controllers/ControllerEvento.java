package com.spring.rest.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.entidades.Evento;
import com.spring.logicaNegocio.ModEvento;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ControllerEvento {

	//Objetos
	ModEvento modelo = new ModEvento();

	//Metodos
	/**
	 * Agrega el event, enviando el objeto a la logica de negocio
	 * @param elEvento
	 */
	@PostMapping("/addEvent")
    boolean addEvent(@RequestBody Evento elEvento) {
		return modelo.addEvento(elEvento);
	}
	
	/**
	 * @return Arreglo con todos Eventos
	 */
	@PostMapping("/getEvents")
	Evento[] getEventos() {
		return this.modelo.getEventos();
    }
}
