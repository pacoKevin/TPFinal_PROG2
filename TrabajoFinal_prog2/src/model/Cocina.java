package model;

import java.util.List;

public class Cocina {

	private String especialidad;
	private List<Pedido> pedidos;
	private Politica politica;
	
	
	
	public Cocina() {
		super();
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Politica getPolitica() {
		return politica;
	}
	public void setPolitica(Politica politica) {
		this.politica = politica;
	}
	@Override
	public String toString() {
		return "Cocina [especialidad=" + especialidad + ", pedidos=" + pedidos + ", politica=" + politica + "]";
	}
	
}
