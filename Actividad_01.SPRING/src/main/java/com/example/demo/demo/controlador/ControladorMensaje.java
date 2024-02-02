package com.example.demo.demo.controlador;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorMensaje {
		

	@GetMapping(value = "mensaje")
	public String obtenerMensaje() {
		return "Esto es un mensaje de prueba";
	}

	@GetMapping(value = "mensajexml", produces = MediaType.APPLICATION_XML_VALUE)
	public String obtenerMensajeHTML() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("<Persona>");
		buffer.append("<id> 5 </id>");
		buffer.append("<Nombre>Sergio</Nombre>");
		buffer.append("<Edad>35</Edad>");
		buffer.append("<Peso>72</Peso>");
		buffer.append("</Persona>");
		
		return buffer.toString();
	}
	@GetMapping(value = "mensajejson", produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerMensajeJSON() {

		StringBuffer buffer = new StringBuffer();
		

		buffer.append("Persona[");
		buffer.append("id: 5, ");
		buffer.append("Nombre: \"Miguel\", ");
		buffer.append("Edad: 27, ");
		buffer.append("Peso: 82");
		buffer.append("]");

		
		return buffer.toString();
	}


}
