package model;

public class Postre extends Cocina{

	private String nombre;
	
	public Postre() {
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
		return "Postre [nombre=" + nombre + "]"+super.toString();
	}
	
	
}
