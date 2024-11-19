package principal;

import Logica.LogicaCliente;
import Logica.LogicaCocina;
import Logica.LogicaComida;
import Logica.LogicaIngrediente;
import Logica.LogicaPedido;
import Logica.LogicaReceta;
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
                case 3: MainCocina.Principal();
                    break;
                case 99: formatearPrograma();
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
            3) Gestión de Secciones de Cocina.
            99) Formatear Programa. (Eliminar todos los registros)
            0) Salir 
	  		""");
	}
	
	public static void formatearPrograma() {
		  LogicaCliente lCliente = new LogicaCliente();
		  LogicaCocina lCocina = new LogicaCocina();
		  LogicaComida lComida = new LogicaComida();
		  LogicaPedido lPedido = new LogicaPedido();
		  LogicaReceta lReceta = new LogicaReceta();
		  
		  lCliente.limpiarClientes();
		  lCocina.limpiarSecciones();
		  lComida.limpiarComida();
		  lPedido.limpiarPedidos();
		  lReceta.limpiarRecetas();
	}

}


