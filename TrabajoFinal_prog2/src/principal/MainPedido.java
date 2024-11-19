package principal;

import java.util.ArrayList;
import java.util.List;

import Logica.LogicaCliente;
import Logica.LogicaCocina;
import Logica.LogicaComida;
import Logica.LogicaPedido;
import model.Cliente;
import model.Cocina;
import model.Comida;
import model.Pedido;

public class MainPedido {
	
	private static LogicaPedido lp=new LogicaPedido();
    private static LogicaCliente lc = new LogicaCliente();
    private static LogicaComida lcm = new LogicaComida();
    private static LogicaCocina lcocina = new LogicaCocina();
	
	public static void Principal() {
		int op =0;
		do{
	    	 System.out.println("""
	    	 		1) Agregar Nuevo Pedido.
	    	 		2) Completar Pedido.
	    	 		3) Cancelar Pedido.
	    	 		4) Mostrar Pedidos.
	    	 		5) Gestion Cliente.
	    	 		6) Calculo de precios.
	    	 		7) Formatear pedidos.
	    	 		0) Salir.
	    	 		""");
	    	 op = Helper.getInteger("Ingrese Opcion: ");
	    	 switch (op) {
					case 1: {
							  Pedido pedido = llenarDatos();
						      lp.generarPedido(pedido);
						      lcocina.repartirPedidosEntreSecciones(pedido);
						      
					        break;}
					case 2: {
						      Pedido pedido = lp.buscarPrimerPedidoPendiente();
						      if(pedido!=null) {
						    	   pedido.completarPedido();
						    	   lcocina.completarPedido(pedido);
						    	   System.out.println("Pedido Completado...");
						      } else {
						    	  System.out.println("No hay pedidos pendientes...");						    	  
						      }
						      
				            break;}
					
					case 3: {
						      int dni =MainCliente.validarDni();
						      Pedido pedido = lp.buscarPedidoPendiente(dni);
						      if(pedido!=null) {
						    	   pedido.cancelarPedido();
						    	   lcocina.cancelarPedido(pedido);
						           System.out.println("Pedido Cancelado...");
						      }else
						    	  System.out.println("Pedido no encontrado...");
						      
				            break;}	
					case 4: {
						    lp.mostrarPedidosSimplificado();
			            break;}	
					case 5: {
						     MainCliente.menu();
				             break;	}
					case 6:{MainCalculoPrecios.calcularPrecioPedido();
					         break;}
					case 7:{lp.limpiarPedidos();
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
		
		boolean cocinaValida = false;
		do {
			pedido.setComidas(validarComida());
			pedido.pedidoPendiente();			
			Cocina seccionNoValida = lcocina.validarCocina(pedido.getComidas());
			if(seccionNoValida == null) {
				cocinaValida = true;
			} else {
				System.out.println("Las comidas de tipo '"+seccionNoValida.getEspecialidad()+"' no están disponibles por el momento.");
				int op = (Helper.getInteger("[1] Elegir otra comida || [-] Cancelar pedido "+seccionNoValida.getEspecialidad()));
				switch (op) {
				case 1: break;
				default: 
					pedido = null;
					cocinaValida = true;
					break;
				}
				
			}
		} while (!cocinaValida);
		
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
    
    /*private static Cocina validarCocina(List<Comida> comidas) {
	    for (Comida comida : comidas) {
	    	Cocina seccion = lcocina.buscarSeccion(comida.getReceta().getTipo()); 
			if(!seccion.puedeRecibirPedidos()) {
				return seccion; // RETORNA SECCION INVALIDA PARA RECIBIR PEDIDOS
			} 
		}
	    
	    return null; // RETORNA NULL SI LAS SECCIONES SON VALIDAS PARE RECIBIR PEDIDOS
	}
    
    private static void repartirPedidosEntreSecciones(Pedido pedido) {
	    for (Comida comida : pedido.getComidas()) {
	    	Cocina seccion = lcocina.buscarSeccion(comida.getReceta().getTipo());
	    	
	    	Pedido pedidoAux = new Pedido();
			pedidoAux.setCliente(pedido.getCliente());
			pedidoAux.pedidoPendiente();
			pedidoAux.agregarComida(comida);
			
			seccion.agregarPedido(pedido);
		}
	}
    
    private static void completarPedido(Pedido pedido) {
    	for (Comida comida : pedido.getComidas()) {
	    	Cocina seccion = lcocina.buscarSeccion(comida.getReceta().getTipo());
	    	
	    	seccion.finalizarPedido();
		}
	}
    private static void cancelarPedido(Pedido pedido) {
    	for (Comida comida : pedido.getComidas()) {
	    	Cocina seccion = lcocina.buscarSeccion(comida.getReceta().getTipo());
	    	Pedido pedidoCocina = seccion.buscarPedidoPendiente(pedido.getCliente(), comida);
	    	seccion.elminarPedido(pedidoCocina);
		}
	}*/
    
}
