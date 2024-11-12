package model;

public class Politica {

	private int limite;
	private String tipoComida;
	public Politica() {
		super();
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public String getTipoComida() {
		return tipoComida;
	}
	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}
	@Override
	public String toString() {
		return "Politica [limite=" + limite + ", tipoComida=" + tipoComida + "]";
	}
}
