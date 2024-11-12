package model;

import java.io.Serializable;

public class Ingrediente implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4879876509472048544L;
	private double costo;
	private String nombre;
	private int stock;
	public Ingrediente() {
		super();
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Ingrediente [costo=" + costo + ", nombre=" + nombre + ", stock=" + stock + "]";
	}
	
}
