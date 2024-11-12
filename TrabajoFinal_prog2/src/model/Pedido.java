package model;

import java.util.List;

public class Pedido {

	private List<Comida> comidas;
	private String estado;
	private Cliente cliente;
	
	public Pedido() {
		super();
	}
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
	@Override
	public String toString() {
		return "Pedido [comidas=" + comidas + ", estado=" + estado + ", cliente=" + cliente + "]";
	}
}
