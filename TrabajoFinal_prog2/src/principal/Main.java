package principal;

import Logica.LogicaCliente;
import Logica.LogicaCocina;
import Logica.LogicaIngrediente;
import model.Cliente;
import model.Cocina;
import model.Ingrediente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/* LogicaIngrediente li = new LogicaIngrediente();	
		
      Ingrediente i = new Ingrediente();
      i.setCosto(34);
      i.setNombre("Zanaoria");
      i.setStock(34); 
      
      Ingrediente i2 = new Ingrediente();
      i2.setCosto(244);
      i2.setNombre("Papa");
      i2.setStock(50); 
      
      Ingrediente i3 = new Ingrediente();
      i3.setCosto(340);
      i3.setNombre("Zanaoria");
      i3.setStock(24); 
     
      li.guardarIngrediente(i);
      li.guardarIngrediente(i2);
      li.guardarIngrediente(i3);
      
      li.MostrarIngredientes();*/
		
	LogicaCliente lc = new LogicaCliente();
	
	lc.limpiarClientes();
	
	Cliente cli = new Cliente();
	cli.setNombre("Homero Simpson");
	cli.setDireccion("Sprinfield");
	
	Cliente cli2 = new Cliente();
	cli2.setNombre("Bart Simpson");
	cli2.setDireccion("Sprinfield");
	
	Cliente cli3 = new Cliente();
	cli3.setNombre("Lisa Simpson");
	cli3.setDireccion("Sprinfield");
	
	lc.guardarCliente(cli);
	lc.guardarCliente(cli2);
	lc.guardarCliente(cli3);
	
	lc.MostrarClientes();
	
	LogicaCocina lcocina = new LogicaCocina();
	
	lcocina.limpiarSecciones();
	
	Cocina seccion1 = new Cocina("Postres", 5);
	
	lcocina.guardarSeccion(seccion1);
	
	lcocina.MostrarSecciones();
		
		 /*int opcion;

	        do {
	            System.out.println("\n--- MENÚ PRINCIPAL ---");
	            System.out.println("1. Gestión de Clientes");
	            System.out.println("2. Gestión de Pedidos");
	            System.out.println("3. Gestión de Comidas");
	            System.out.println("4. Gestión de Recetas");
	            System.out.println("5. Gestión de Ingredientes");
	            System.out.println("6. Gestión de Secciones de Cocina");
	            System.out.println("7. Cálculo de Precios");
	            System.out.println("8. Salir");
	            System.out.print("Seleccione una opción: ");
	            opcion = Helper.getInteger("Seleccione una opcion: ");

	            switch (opcion) {
	                case 1:
	                    //menuClientes();
	                	System.out.println("opcion 1");
	                    break;
	                case 2:
	                    //menuPedidos();
	                	System.out.println("opcion 2");
	                    break;
	                case 3:
	                    //menuComidas();
	                	System.out.println("opcion 3");
	                    break;
	                case 4:
	                    //menuRecetas();
	                	System.out.println("opcion 4");
	                    break;
	                case 5:
	                    //menuIngredientes();
	                	System.out.println("opcion 5");
	                    break;
	                case 6:
	                    //menuSecciones();
	                	System.out.println("opcion 6");
	                    break;
	                case 7:
	                    //calculoPrecios();
	                	System.out.println("opcion 7");
	                    break;
	                case 8:
	                    System.out.println("Saliendo del sistema...");
	                    break;
	                default:
	                    System.out.println("Opción no válida. Intente de nuevo.");
	            }
	        } while (opcion != 8);*/

    }

}


