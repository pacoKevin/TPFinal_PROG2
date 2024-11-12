package Logica;

import java.io.File;
import java.util.List;

import data.AccesoDatos;
import model.Cliente;
import model.Ingrediente;

public class LogicaCliente {
	private AccesoDatos datos;
	
	public LogicaCliente() {
		try {	
			File file= new File("Clientes.txt");
	        if(!file.exists()) {
	            file.createNewFile();
	        }
			this.datos=new AccesoDatos(file.getPath());
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.println("error: "+e.getMessage());
		}
	}
	
   public boolean guardarCliente(Cliente cli) {
	   try {
		   List<Cliente> clientes= this.datos.listObjects();
		   clientes.add(cli);
		   this.datos.saveObject(clientes);
		   return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al Agregar Cliente: "+e.getMessage());
		return false;
	}
   }
   
   public List<Cliente> listarClientes(){	
	   List<Cliente> clientes= this.datos.listObjects();  
		  
		   return clientes;	
   }
   
   public void MostrarClientes() {
	   List<Cliente> clientes= this.datos.listObjects();
		for(Cliente c : clientes) {
			System.out.println(c.toString());		   
		}
			
	}
}
