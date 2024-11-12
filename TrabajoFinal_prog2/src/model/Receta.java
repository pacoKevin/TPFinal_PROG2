package model;

import java.util.List;

public class Receta {

	private String nombre;
	private int tiempoCoccion;
	private String tipo;
	private String modoPreparacion;
	private int complejidad;
	private List<Ingrediente> ingredientes;
	private List<Receta> recetas;
	public Receta() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTiempoCoccion() {
		return tiempoCoccion;
	}
	public void setTiempoCoccion(int tiempoCoccion) {
		this.tiempoCoccion = tiempoCoccion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModoPreparacion() {
		return modoPreparacion;
	}
	public void setModoPreparacion(String modoPreparacion) {
		this.modoPreparacion = modoPreparacion;
	}
	public int getComplejidad() {
		return complejidad;
	}
	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public List<Receta> getRecetas() {
		return recetas;
	}
	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
	@Override
	public String toString() {
		return "Receta [nombre=" + nombre + ", tiempoCoccion=" + tiempoCoccion + ", tipo=" + tipo + ", modoPreparacion="
				+ modoPreparacion + ", complejidad=" + complejidad + ", ingredientes=" + ingredientes + ", recetas="
				+ recetas + "]";
	}
}
