package model;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import Logica.LogicaIngrediente;

public class Receta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1016436892243695641L;
	private String nombre;
	private int tiempoCoccion;
	private String tipo;
	private String modoPreparacion;
	private int complejidad;
	private Dictionary<Ingrediente,Integer> ingredientes;
	private List<Receta> recetas;
	public Receta() {
		super();
		this.ingredientes= new Hashtable<Ingrediente, Integer>();
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
	
	public Dictionary<Ingrediente, Integer> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Dictionary<Ingrediente, Integer> ingredientes) {
		this.ingredientes = ingredientes;
	}

	
	public List<Receta> getRecetas() {
		return recetas;
	}
	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
	
	
	public boolean disponible() {
		LogicaIngrediente li = new LogicaIngrediente();
		Enumeration<Ingrediente> keys = this.ingredientes.keys();
		while(keys.hasMoreElements()) {		  
			 Ingrediente i = keys.nextElement();
			 Ingrediente buscarIngrediente = li.buscarIngrediente(i.getNombre());
			 if(buscarIngrediente.getStock() < this.ingredientes.get(i)) 
				   return false;
		}
	   return true;
	}
	
	
	public double costoIngredientes() {
		double costo=0;
		Enumeration<Ingrediente> keys = this.ingredientes.keys();
		 while(keys.hasMoreElements()) {				 	
			   Ingrediente i = keys.nextElement();
			   int cantidadIngrdientes= this.ingredientes.get(i);	
		       costo+=(i.getCosto()*cantidadIngrdientes);
		}
		return costo;
	}
	
	@Override
	public String toString() {
		String complej;
		if(this.complejidad==1) 
			complej="Baja";
		if(this.complejidad==2) 
			complej="Media";
		if(this.complejidad==3) 
			complej="Alta";
		
		return "****RECETA****\n" +
	           "Nombre: " + nombre + "\n" + 
			   "Tiempo de Cocción: " + tiempoCoccion + "\n" + 
	           "Tipo: " + tipo + "\n" + 
			   "Modo de Preparación: " + modoPreparacion + "\n" + 
	           "Complejidad: " + complejidad + "\n" + 
			   "Ingredientes: " + ingredientes + "\n" + 
	           "Recetas: " + recetas;
	}
}
