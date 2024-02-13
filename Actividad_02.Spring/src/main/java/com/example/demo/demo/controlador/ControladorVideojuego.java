package com.example.demo.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.entidad.Videojuego;
import com.example.demo.demo.persistencia.DaoVideojuego;


@RestController
public class ControladorVideojuego {
	@Autowired
	private DaoVideojuego daoVideojuego;

	@GetMapping(path="videojuegos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Videojuego> getPersona(@PathVariable("id") int id) {
		System.out.println("Buscando persona con id: " + id);
		Videojuego p = daoVideojuego.get(id);
		if(p != null) {
			return new ResponseEntity<Videojuego>(p,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}

	@PostMapping(path="videojuegos",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaPersona(@RequestBody Videojuego p) {
		System.out.println("altaPersona: objeto persona: " + p);
		daoVideojuego.add(p);
		return new ResponseEntity<Videojuego>(p,HttpStatus.CREATED);//201 CREATED
	}
	
	@GetMapping(path="videojuegos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarPersonas(
			@RequestParam(name="nombre",required=false) String nombre) {
		List<Videojuego> listaPersonas = null;
		//Si no me viene el nombre, devolvemos toda la lista
		if(nombre == null) {
			System.out.println("Listando los videojuegos");
			listaPersonas = daoVideojuego.list();			
		}else {
			System.out.println("Listando los videojuegos por nombre: " + nombre);
			listaPersonas = daoVideojuego.listByNombre(nombre);
		}
		System.out.println(listaPersonas);
		return new ResponseEntity<List<Videojuego>>(listaPersonas,HttpStatus.OK);
	}
	
	
	@PutMapping(path="videojuegos/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarPersona(
			@PathVariable("id") int id, 
			@RequestBody Videojuego p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		Videojuego pUpdate = daoVideojuego.update(p);
		if(pUpdate != null) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	@DeleteMapping(path="videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarPersona(@PathVariable("id") int id) {
		System.out.println("ID a borrar: " + id);
		Videojuego p = daoVideojuego.delete(id);
		if(p != null) {
			return new ResponseEntity<Videojuego>(p,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}

}
