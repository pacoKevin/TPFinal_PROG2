package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Cocina implements Serializable{

	private static final long serialVersionUID = 519532256191L;
	private String especialidad;
	private int limite;
	private List<Pedido> pedidosPendientes;
	private List<Ingrediente> ingredientes;
	
	
	public Cocina(String especialidad, int limite) {
		this.especialidad = especialidad;
		this.limite = limite;
		this.pedidosPendientes = new ArrayList<Pedido>();
		this.ingredientes = new ArrayList<Ingrediente>();
	}
	
	// GETTERS & SETTERS
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	public List<Pedido> getPedidosPendientes() {
		return pedidosPendientes;
	}
	public void setPedidosPendientes(List<Pedido> pedidos) {
		this.pedidosPendientes = pedidos;
	}
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	// Another methods
	// Lista de Pedidos
	public void agregarPedido(Pedido pedido) {
		pedidosPendientes.add(pedido);			
	}
	
	public void elminarPedido(Pedido pedido) {
		pedidosPendientes.remove(pedido);			
	}
	
	public void finalizarPedido() {
		pedidosPendientes.remove(0);			
	}
	
	public Pedido buscarPedidoPendiente(Cliente cliente) {
		Pedido pedido = null;
		for (Pedido ped : pedidosPendientes) {
			if(ped.getCliente().equals(cliente)) {
				pedido = ped;
				break;
			}
		}
		return pedido;
	}
	
	public Pedido buscarPedidoPendiente(Cliente cliente, Comida comida) {
		Pedido pedido = null;
		for (Pedido ped : pedidosPendientes) {
			if(ped.getCliente().equals(cliente) && ped.getComidas().contains(comida)) {
				pedido = ped;
				break;
			}
		}
		return pedido;
	}
	
	// Lista de Ingredientes
	public void agregarIngrediente(Ingrediente ingrediente) {
		ingredientes.add(ingrediente);			
	}
	
	public void elminarIngrediente(Ingrediente ingrediente) {
		ingredientes.remove(ingrediente);			
	}
	
	public Ingrediente buscarIngrediente(String nombreIngrediente) {
		Ingrediente ingrediente = null;
		for (Ingrediente ingr : ingredientes) {
			if(ingr.getNombre().equals(nombreIngrediente)) {
				ingrediente = ingr;
				break;
			}
		}
		return ingrediente;
	}
	
	// Disponibilidad de pedidos
	public boolean puedeRecibirPedidos() {
		if(pedidosPendientes.size() >= limite) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Cocina [especialidad=" + especialidad + ", limite=" + limite + ", pedidosPendientes="
				+ pedidosPendientes + ", ingredientes=" + ingredientes + "]";
	}
	
}
