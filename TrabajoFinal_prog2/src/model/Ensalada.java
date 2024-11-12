package model;

public class Ensalada extends Cocina {

	private String nombre;

	public Ensalada() {
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
		return "Ensalada [nombre=" + nombre + "] "+super.toString();
	}	
}
