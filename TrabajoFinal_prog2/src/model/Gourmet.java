package model;

public class Gourmet extends Cocina{

	private String nombre;

	public Gourmet() {
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
		return "Gourmet [nombre=" + nombre + "]"+super.toString();
	}
}
