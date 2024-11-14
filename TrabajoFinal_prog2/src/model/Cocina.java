package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cocina implements Serializable{

	private static final long serialVersionUID = 519532256191L;
	private String especialidad;
	private List<Pedido> pedidosPendientes;
	private List<Pedido> pedidosFinalizados;
	private int limite;
	
	
	public Cocina(String especialidad, int limite) {
		this.especialidad = especialidad;
		this.pedidosPendientes = new ArrayList<Pedido>();
		this.pedidosFinalizados = new ArrayList<Pedido>();
		this.limite = limite;
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
	
	public List<Pedido> getpedidosPendientes() {
		return pedidosPendientes;
	}
	public void setpedidosPendientes(List<Pedido> pedidos) {
		this.pedidosPendientes = pedidos;
	}
	
	public List<Pedido> getpedidosFinalizados() {
		return pedidosFinalizados;
	}
	public void setpedidosFinalizados(List<Pedido> pedidos) {
		this.pedidosFinalizados = pedidos;
	}
	
	// Another methods
	public void agregarPedido(Pedido pedido) {
		pedidosPendientes.add(pedido);
	}
	
	public Pedido buscarPedidoPendiente(Pedido pedido) {
		int indice = pedidosPendientes.indexOf(pedido);
		if(indice == -1) return null;
		Pedido pedidoPendiente = pedidosPendientes.get(indice);
		return pedidoPendiente;
	}
	
	public void completarPedido(Pedido pedido) {
		pedidosPendientes.remove(pedido);
		pedido.completarPedido();
		pedidosFinalizados.add(pedido);
	}
	
	public void cancelarPedido(Pedido pedido) {
		pedidosPendientes.remove(pedido);
		pedido.cancelarPedido();
		pedidosFinalizados.add(pedido);
	}

	
	
	@Override
	public String toString() {
		return "Cocina [especialidad=" + especialidad + ", pedidosPendientes=" + pedidosPendientes
				+ ", pedidosFinalizados=" + pedidosFinalizados + ", limite=" + limite + "]";
	}
	
}
