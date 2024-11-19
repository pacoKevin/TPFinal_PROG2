package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable{

	private List<Comida> comidas;
	private String estado;
	private Cliente cliente;
	
	public Pedido() {
		super();
		comidas = new ArrayList<Comida>();
	}
	
	// GETTERS & SETTERS
	public List<Comida> getComidas() {
		return comidas;
	}
	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	// Another methods
	public void pedidoPendiente() {
		this.estado = "Pendiente";
	}
	public void cancelarPedido() {
		this.estado = "Cancelado";
	}
	public void completarPedido() {
		this.estado = "Completado";
	}
	
	public void agregarComida(Comida comida) {
		this.comidas.add(comida);
	}	
	
	@Override
	public String toString() {
		return "Pedido [comidas=" + comidas + ", estado=" + estado + ", cliente=" + cliente + "]";
	}
}
