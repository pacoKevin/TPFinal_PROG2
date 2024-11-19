package principal;

import java.util.List;

import Logica.LogicaIngrediente;
import model.Cocina;
import model.Ingrediente;

public class MainIngrediente {

	
	public static void principal(Cocina seccion) {
		LogicaIngrediente li= new LogicaIngrediente(seccion);
		int op=0;
		do{
	    	 System.out.println("""
	    	 		1) Agregar Nuevo Ingrediente.
	    	 		2) Mostrar todos los Ingredientes.
	    	 		3) Mostrar ingredientes disponibles.
	    	 		0) Salir
	    	 		""");
	    	 op = Helper.getInteger("Ingrese Opcion: ");
	    	 switch (op) {
					case 1: li.guardarIngrediente(completarDatos());
				        break;
					        
					case 2: li.mostrarIngredientes();
			        	break;
				        	
					case 3: li.listarIngredientesDisponibles();
				        break;
					        
					case 0: break;
					
					default: throw new IllegalArgumentException("Error en menu Ingrediente...");
	    	 }
	    	}while(op!=0);
	}
	
	private static Ingrediente completarDatos() {
		Ingrediente ing = new Ingrediente();
		ing.setNombre(Helper.getString("Ingrese Nombre: "));
		ing.setCosto(Helper.getDouble("Ingrese Costo: "));
		ing.setStock(Helper.getInteger("Ingrese Stock: "));
		return ing;
	}

}
