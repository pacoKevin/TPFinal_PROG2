package principal;

import Logica.LogicaCliente;
import model.Cliente;

public class MainCliente {

	private static LogicaCliente lc=new LogicaCliente();
	
     public static void menu() {
    	int op=0;
    	do{
    	 System.out.println("""
    	 		1) Agregar Nuevo Cliente.
    	 		2) Mostrar Clientes Existentes.
    	 		0) Salir
    	 		""");
    	 op = Helper.getInteger("Ingrese Opcion: ");
    	 switch (op) {
				case 1: {
					    lc.guardarCliente(completarDatos());
				        break;}
				case 2: {
					      lc.MostrarClientes();
			        break;}		
				case 0: {break;}
				default:
					throw new IllegalArgumentException("Error en menu cliente...");
				}
    	}while(op!=0);
     }
     
     private static Cliente completarDatos() {
    	 Cliente cli = new Cliente();
    	 cli.setDni(validarDni());
    	 cli.setNombre(Helper.getString("Ingrese nombre: "));
    	 cli.setDireccion(Helper.getString("Ingrese Direccion: "));
    	 return cli;
     }
     
    public static int validarDni() {
    	while(true) {
    		int dni = Helper.getInteger("Ingre DNI: ");
    		if(dni>11111111 && dni<99999999) {
    			return dni;
    		}else
    			System.out.println("DNI incorrecto..");
    	}
    }
}
