package model;

public class Comida {

	private String nombre;
	private Receta receta;
	public Comida(String nombre, Receta receta) {
		super();
		this.nombre = nombre;
		this.receta = receta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	@Override
	public String toString() {
		return "Comida [nombre=" + nombre + ", receta=" + receta + "]";
	}
	
}
