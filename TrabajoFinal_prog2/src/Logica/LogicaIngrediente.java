package Logica;

import java.io.File;
import java.util.List;

import data.AccesoDatos;
import model.Ingrediente;

public class LogicaIngrediente {

	private AccesoDatos datos;
	
	public LogicaIngrediente() {
		try {	
			File file= new File("Ingredientes.txt");
	        if(!file.exists()) {
	            file.createNewFile();
	        }
			this.datos=new AccesoDatos(file.getPath());
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.println("error: "+e.getMessage());
		}
	}
	
   public boolean guardarIngrediente(Ingrediente ing) {
	   try {
		   List<Ingrediente> ingredientes= this.datos.listObjects();
		   ingredientes.add(ing);
		   this.datos.saveObject(ingredientes);
		   return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al Agregar Lote: "+e.getMessage());
		return false;
	}
   }
   
   public List<Ingrediente> listarIngredientes(){	
		   List<Ingrediente> ingredientes= this.datos.listObjects();	  
		  
		   return ingredientes;	
   }
   
   public void MostrarIngredientes() {
	   List<Ingrediente> list = this.datos.listObjects();
		for(Ingrediente l : list) {
			System.out.println(l.toString());			
		    
		}
			
	}
	
}
