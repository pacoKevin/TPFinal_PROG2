package model;

import java.util.List;

public class Horneada extends Cocina {

	private String nombre;
	
	public Horneada() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Horneada [nombre=" + nombre + "]"+super.toString();
	}
	
	

}
