package principal;

import java.util.ArrayList;
import java.util.List;

import Logica.LogicaCliente;
import Logica.LogicaComida;
import Logica.LogicaPedido;
import model.Cliente;
import model.Comida;
import model.Pedido;

public class MainPedido {
	
	private static LogicaPedido lp=new LogicaPedido();
    private static LogicaCliente lc = new LogicaCliente();
    private static LogicaComida lcm = new LogicaComida();
	
	public static void Principal() {
		int op =0;
		do{
	    	 System.out.println("""
	    	 		1) Agregar Nuevo Pedido.
	    	 		2) Cancelar Pedido.
	    	 		3) Mostrar Pedidos.
	    	 		4) Gestion Cliente.
	    	 		5) Calculo de precios.
	    	 		0) Salir.
	    	 		""");
	    	 op = Helper.getInteger("Ingrese Opcion: ");
	    	 switch (op) {
					case 1: {
						      lp.generarPedido(llenarDatos());
					        break;}
					case 2: {
						      int dni =MainCliente.validarDni();
						      Pedido pedido = lp.buscarPedido(dni);
						      if(pedido!=null) {
						    	   pedido.cancelarPedido();
						           lp.cancelarPedido(pedido);
						           System.out.println("Pedido Cancelado...");
						      }else
						    	  System.out.println("Pedido no encontrado...");
						      
				            break;}	
					case 3: {
						    lp.mostrarPedidos();
			            break;}	
					case 4: {
						     MainCliente.menu();
				             break;	}
					case 5:{MainCalculoPrecios.calcularPrecioPedido();
					         break;}
					case 0: {break;}
					default:
						throw new IllegalArgumentException("Error en menu cliente...");
					}
	    	}while(op!=0);
	}
	
	private static Pedido llenarDatos() {
		Pedido pedido = new Pedido();
		
		pedido.setCliente(validarCliente());
		pedido.setComidas(validarComida());
		pedido.pedidoPendiente();	
		
		return pedido;
	}
	
	private static Cliente validarCliente() {
	    Cliente cliente = new Cliente();
	    
        int dni = MainCliente.validarDni();
        cliente = lc.buscarCliente(dni);
        if(cliente!=null)
          	return cliente; 
        else {
        	System.out.println("****Nuevo Cliente****");
        	Cliente cliNuevo = MainCliente.completarDatos();
        	MainCliente.lc.guardarCliente(cliNuevo);
          	return cliNuevo;}
	}
	
    private static List<Comida> validarComida(){
    	List<Comida> listComidas = new ArrayList<Comida>();
    	System.out.println("****MENU****");
    	lcm.mostrarComidas();
    	char op=' ';
    	
    	do {
    		String nombreComida = Helper.getString("Ingrese nombre de comida: ");
    		Comida comida = lcm.buscarComida(nombreComida);
    		if(comida!=null) {
    			listComidas.add(comida);
    		}else
    			System.out.println("Comida no existe en el menu...");
    	   op=Helper.getCharacter("Desea seguir s/n: ");
    	}while(op!='n');
    	
    	return listComidas;
    }
}
