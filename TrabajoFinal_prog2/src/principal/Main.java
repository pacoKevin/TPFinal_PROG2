package principal;

import Logica.LogicaCliente;
import Logica.LogicaCocina;
import Logica.LogicaIngrediente;
import model.Cliente;
import model.Cocina;
import model.Ingrediente;
import model.Receta;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;

        do {          
            menuPrincipal();
            opcion = Helper.getInteger("Seleccione una opcion: ");

            switch (opcion) {               
                case 1: MainPedido.Principal();
                    break;
                case 2: MainComida.Principal();
                    break;
                case 3: MainIngrediente.principal();
                    break;
                case 4: MainCocina.Principal();
                    break;
                case 0: 
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion!=0);
    }
	
	public static void menuPrincipal() {
	  System.out.println("""
	  	    ***** MENÚ PRINCIPAL*****          
            1) Gestión de Pedidos.
            2) Gestión de Comidas.
            3) Gestión de Ingredientes.
            4) Gestión de Secciones de Cocina.
            0) Salir 
	  		""");
	}

}


