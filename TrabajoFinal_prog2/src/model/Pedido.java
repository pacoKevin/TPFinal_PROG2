package model;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable{

	private List<Comida> comidas;
	private String estado;
	private Cliente cliente;
	
	public Pedido() {
		super();
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
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [comidas=" + comidas + ", estado=" + estado + ", cliente=" + cliente + "]";
	}
}
