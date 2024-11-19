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
                case 1: MainCliente.menu();
                    break;
                case 2: MainPedido.Principal();
                    break;
                case 3: MainComida.Principal();
                    break;
                case 4: MainReceta.Principal();
                    break;
                case 5: MainIngrediente.principal();
                    break;
                case 6:
                    //menuSecciones();
                		
                		MainCocina.Principal();
                    break;
                case 7:
                         MainCalculoPrecios.calcularPrecioPedido();
                    break;
                case 0: 
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion!=0);

		
		
	   
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
		
/*	LogicaCliente lc = new LogicaCliente();
	
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
	
	lcocina.MostrarSecciones();*/

    }
	
	public static void menuPrincipal() {
	  System.out.println("""
	  	    ***** MENÚ PRINCIPAL*****
            1) Gestión de Clientes.
            2) Gestión de Pedidos.
            3) Gestión de Comidas.
            4) Gestión de Recetas.
            5) Gestión de Ingredientes.
            6) Gestión de Secciones de Cocina.
            7) Cálculo de Precios.
            0) Salir 
	  		""");
	}

}


