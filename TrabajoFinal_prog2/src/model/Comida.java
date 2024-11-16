package model;

import java.io.Serializable;

public class Comida implements Serializable{

	private String nombre;
	private Receta receta;
	public Comida() {
		super();
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
	
	public double costoComida() {
	    double costoTotal=0;
	    costoTotal+=this.receta.costoIngredientes();
	    costoTotal+=this.adicionalTipoReceta();
	    costoTotal+=this.adicionalComplejidadReceta();
		
		return costoTotal;
	}
	
	private double adicionalTipoReceta() {
		if(this.receta.getTipo().equals("horno"))
			return 2000;
		if(this.receta.getTipo().equals("gurmet"))
			return 2500;
		if(this.receta.getTipo().equals("ensalada"))
			return 1000;
		if(this.receta.getTipo().equals("postre"))
			return 1500;		
		return 0;
	}
	
	private double adicionalComplejidadReceta() {
		if(this.receta.getComplejidad()==1)
			return 500;
		if(this.receta.getComplejidad()==2)
			return 1000;
		if(this.receta.getComplejidad()==3)
			return 2000;			
		return 0;
	}
	
	@Override
	public String toString() {
		return "Comida [nombre=" + nombre + ", receta=" + receta + "]";
	}
	
}
