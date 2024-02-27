package com.example.demo.demo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.demo.entidad.Videojuego;







@Component
public class DaoVideojuego {
	public List<Videojuego> listaVideojuegos;
	public int contador;
	public DaoVideojuego() {
		System.out.println("DaoVideojuego -> Creando la lista de videojuegos!");
		listaVideojuegos = new ArrayList<Videojuego>();
		Videojuego p1 = new Videojuego(contador++, "Last of us", "Naughty Dog", 9);// ID: 0
		Videojuego p2 = new Videojuego(contador++, "GTA", "Rockstar Games", 6);// ID: 0
		Videojuego p3 = new Videojuego(contador++, "Age of empires", " Ensemble Studios", 5);// ID: 0
		Videojuego p4 = new Videojuego(contador++, "LOL", " League of Legends", 4);// ID: 0
		Videojuego p5 = new Videojuego(contador++, "Los Simpsons", "Inventada", 3);// ID: 0

		listaVideojuegos.add(p1);
		listaVideojuegos.add(p2);
		listaVideojuegos.add(p3);
		listaVideojuegos.add(p4);
		listaVideojuegos.add(p5);
	}
	
	public Videojuego get(int posicion) {
		try {
			return listaVideojuegos.get(posicion);
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Persona fuera de rango");
			return null;
		}
	}

	public List<Videojuego> list() {
		return listaVideojuegos;
	}

	public void add(Videojuego p) {
		p.setId(contador++);
		listaVideojuegos.add(p);
	}

	public Videojuego delete(int posicion) {
		try {
			return listaVideojuegos.remove(posicion);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("delete -> Persona fuera de rango");
			return null;
		}
	}

	public Videojuego update(Videojuego p) {
		try {
			Videojuego pAux = listaVideojuegos.get(p.getId());
			pAux.setNombre(p.getNombre());
			pAux.setCompañia(p.getCompañia());
			pAux.setInt(p.getInt());

			return pAux;
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("update -> Persona fuera de rango");
			return null;
		}
	}

	public List<Videojuego> listByNombre(String nombre) {
		List<Videojuego> listaPersonasAux = new ArrayList<Videojuego>();
		for (Videojuego p : listaVideojuegos) {
			if (p.getCompañia().equalsIgnoreCase(nombre)) {// contains()
				listaPersonasAux.add(p);
			}
		}
		return listaPersonasAux;
	}
	
	
	

}
