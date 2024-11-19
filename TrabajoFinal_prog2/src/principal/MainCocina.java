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
import model.Ingrediente;
import model.Pedido;

public class MainCocina {
	
	private static LogicaCocina lc = new LogicaCocina();
	
	public static void Principal() {
		int op =0;
		do{
	    	 System.out.println("""
	    	 		1) Agregar Nueva Seccion.
	    	 		2) Mostrar Secciones.
	    	 		3) Limpiar Secciones.
	    	 		4) Gestion Ingredientes.
	    	 		0) Salir.
	    	 		""");
	    	 op = Helper.getInteger("Ingrese Opcion: ");
	    	 switch (op) {
					case 1: {
						    	lc.guardarSeccion(nuevaSeccion());
						    	System.out.println("Seccion Creada");
					        	break;
					        }
					case 2: {
						      	lc.MostrarSecciones();
				            	break;
				            }
					case 3: {
						      	lc.limpiarSecciones();
						      	System.out.println("Secciones eliminadas");
				            	break;
				            }
					case 4: {
						      	MainIngrediente.principal(seleccionarSeccion());
				            	break;
				            }
					case 0: {break;}
					default:
						throw new IllegalArgumentException("Error en menu Cocina...");
					}
	    	}while(op!=0);
		
	}
	
	public static Cocina nuevaSeccion() {
		Cocina seccion = new Cocina(
				Helper.getString("Ingrese el nombre de la seccion: "), 
				Helper.getInteger("Ingrese el limite de comidas a recibir: "));
		seccion.setIngredientes(agregarIngredientes());
		return seccion;
	}
	
	public static ArrayList<Ingrediente> agregarIngredientes() {
		int cantidad = Helper.getInteger("Cantidad de ingredientes a agregar: ");
		ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();
		for (int i = 0; i < cantidad; i++) {
			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setNombre(Helper.getString("Ingrese el nombre del ingrediente: "));
			ingrediente.setCosto(Helper.getDouble("Ingrese su costo: "));
			ingrediente.setStock(Helper.getInteger("Ingrese el stock: "));
			
			listaIngredientes.add(ingrediente);
			System.out.println("Ingrediente añadido...");
		}
		return listaIngredientes;
	}
	
	public static Cocina seleccionarSeccion() {
		Cocina seccion = null;
		
		List<Cocina> secciones = lc.listarSecciones();
		
		while (true) {
			System.out.println("Secciones:  ");
			for (int i = 1; i <= secciones.size(); i++) {
				System.out.println(i + ") " + secciones.get(i-1).getEspecialidad());
			}
			
			int opcion = Helper.getInteger("Elija una seccion: ");
			if(opcion > 0 && opcion <= secciones.size()) {
				seccion = secciones.get(opcion-1);
				break;
			}
			System.out.println("Elija alguna seccion existente.");
		} 
		
		return seccion;
	}
	
	public static Cocina seleccionarSeccion(String inputMessage, String errorMessage) {
		Cocina seccion = null;
		
		List<Cocina> secciones = lc.listarSecciones();
		
		while (true) {
			System.out.println("Secciones:  ");
			for (int i = 1; i <= secciones.size(); i++) {
				System.out.println(i + ") " + secciones.get(i-1).getEspecialidad());
			}
			
			int opcion = Helper.getInteger(inputMessage);
			if(opcion > 0 && opcion <= secciones.size()) {
				seccion = secciones.get(opcion-1);
				break;
			}
			System.out.println(errorMessage);
		} 
		
		return seccion;
	}
	

}
