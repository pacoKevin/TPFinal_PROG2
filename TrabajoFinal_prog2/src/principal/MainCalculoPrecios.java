package principal;

import java.util.Enumeration;
import java.util.List;

import Logica.LogicaCliente;
import Logica.LogicaPedido;
import model.Comida;
import model.Ingrediente;
import model.Pedido;
import model.Receta;

public class MainCalculoPrecios {

	private static LogicaCliente lc = new LogicaCliente();
	private static LogicaPedido lp =new LogicaPedido();
	 
	public static void calcularPrecioPedido() {
		
		int dniCliente = MainCliente.validarDni();
		//Pedido buscarPedido=lp.buscarPedido(dniCliente);
		List<Pedido> pedidos=lp.buscarPedidos(dniCliente);
		for(Pedido buscarPedido: pedidos)
		if(buscarPedido!=null) {
			System.out.println("*************PEDIDO*****************");
			System.out.println("Cliente: "+buscarPedido.getCliente().getNombre());
		    mostrarPrecioIngredientes(buscarPedido);
		    System.out.println("************************************");
		}
		
	}
	
	private static void mostrarPrecioIngredientes(Pedido pedido) {
		for(Comida c: pedido.getComidas()) {
			System.out.println("Comida: "+c.getNombre());
		   Enumeration<Ingrediente> ingredientes = c.getReceta().getIngredientes().keys();
		   while(ingredientes.hasMoreElements()) {
			   Ingrediente ing = ingredientes.nextElement();
			   System.out.println("Ingrediente: "+ing.getNombre()+", Precio: "+ing.getCosto()+", Cantidad: "+c.getReceta().getIngredientes().get(ing));
		   }
		   System.out.println("Total ingredientes: "+"$"+c.getReceta().costoIngredientes());
		   System.out.println("Adicional por tipo de comida, "+c.getReceta().getTipo()+": "+adicionalPorTipo(c.getReceta().getTipo()));
		   adicionalPorComplejidad(c.getReceta().getComplejidad());
		   System.out.println("Total costo de pedido: "+c.costoComida());
		}
	}
	
	private static double adicionalPorTipo(String tipo) {
		if(tipo.equals("horno")) {
			return 2000;
		}
		if(tipo.equals("gurmet")) {
			return 2500;
		}
		if(tipo.equals("ensalada")) {
			return 1000;
		}
		if(tipo.equals("postre")) {
			return 1500;
		}
		return 0;
	}
	
	private static void adicionalPorComplejidad(int complejidad) {
		if(complejidad==1)
			System.out.println("Adicional por complejidad, Baja: "+500);
		if(complejidad==2)
			System.out.println("Adicional por complejidad, Media: "+1000);
		if(complejidad==3)
			System.out.println("Adicional por complejidad, Alta: "+2000);
	}
	
}
