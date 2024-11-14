package principal;

import Logica.LogicaIngrediente;
import model.Ingrediente;

public class MainIngrediente {

	private static LogicaIngrediente li= new LogicaIngrediente();
	
	public static void principal() {
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
					case 1: {
						     li.guardarIngrediente(completarDatos());  
					        break;}
					case 2: {
						      li.MostrarIngredientes();
				        break;}
					case 3: {
					          li.listarIngredientesDisponibles();
			        break;}
					case 0: {break;}
					default:
						throw new IllegalArgumentException("Error en menu Ingrediente...");
					}
	    	}while(op!=0);
	}
	
	private static Ingrediente completarDatos() {
		Ingrediente ing = new Ingrediente();
		ing.setNombre(Helper.getString("Ingre Nombre: "));
		ing.setCosto(Helper.getDouble("Ingrese Costo: "));
		ing.setStock(Helper.getInteger("Ingrese Stock: "));
		return ing;
	}
}
