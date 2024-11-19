package principal;

import java.util.ArrayList;
import java.util.List;

import Logica.LogicaComida;
import Logica.LogicaReceta;
import model.Comida;
import model.Receta;

public class MainComida {

	private static LogicaComida lc = new LogicaComida();
	private static LogicaReceta lr = new LogicaReceta();
	
	public static void Principal() {
		int op =0;
		do{
	    	 System.out.println("""
	    	 		1) Agregar Nueva Comida.
	    	 		2) Mostrar Comidas.
	    	 		3) Gestionar Recetas.
	    	 		0) Salir
	    	 		""");
	    	 op = Helper.getInteger("Ingrese Opcion: ");
	    	 switch (op) {
					case 1: {
						      lc.guardarComida(completarDatos());
					        break;}
					case 2: { lc.mostrarComidas();					
				            break;}	
					case 3:{
						     MainReceta.Principal();
					         break;}
					case 0: {break;}
					default:
						throw new IllegalArgumentException("Error en menu cliente...");
					}
	    	}while(op!=0);
	}
	
	public static Comida completarDatos() {
		Comida comida = new Comida();		
		comida.setNombre(validarNombre());
		comida.setReceta(ingresarReceta());
		return comida;
	}
	
	private static String validarNombre() {
		boolean band=true;
		do {
			String nombre = Helper.getString("Ingrese Nombre: ");
			if(lc.buscarComida(nombre)==null) {
				return nombre;
			}else {
				System.out.println("Una receta con el mismo nombre ya existe!!");
			}
		}while(band);	
		return null;
	}
	
	 private static Receta ingresarReceta(){
		  lr.mostrarRecetas();
		  Receta rec= null;
		  while(true) {
			  String nombreReceta= Helper.getString("Ingrese Receta: (para cancelar ingrese 'salir')");
				rec = lr.buscarReceta(nombreReceta);
				if(rec!=null) {
					return rec;
				}
				if(nombreReceta.equals("salir")){
					break;
				} else {
					System.out.println("Receta no existe...");	
				}
				
		  }
		  return null;
	  }
}
