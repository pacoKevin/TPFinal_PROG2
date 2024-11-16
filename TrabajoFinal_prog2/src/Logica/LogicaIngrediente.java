package Logica;

import java.io.File;
import java.util.ArrayList;
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
   
   public void listarIngredientesDisponibles(){	
	    try {
			  List<Ingrediente> list = new ArrayList<Ingrediente>();
			  for (Ingrediente i :(List<Ingrediente>) this.datos.listObjects()) {
				   if(i.getStock()>0) {
					   System.out.println(i.toString());
				   }
			      }
			 
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al lista ing disponibles.."+e.getMessage());
		}   
   }
   
   public void actualizacionStock(String nombre, int cantidad,String opcion) {
	   try {
		  List<Ingrediente> list = this.datos.listObjects();
		  for (Ingrediente i: list) {
			    if(i.getNombre().equals(nombre)) {
			    	if(opcion.equals("agregar"))
			    	     i.setStock(i.getStock()+cantidad);
			    	if(opcion.equals("quitar"))
			    		 i.setStock(i.getStock()-cantidad);
			    }
		    }
		  this.datos.saveObject(list);
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException("Error al actualizar Stock..."+e.getMessage());
	}
   }
   
   public Ingrediente buscarIngrediente(String nombre) {
	   
	   try {
		    Ingrediente ing = new Ingrediente();
		    for (Ingrediente i :(List<Ingrediente>) this.datos.listObjects()) {
				if(i.getNombre().equals(nombre)) {
				   return i;
				}					
			}
		    return null;
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException("Error al buscar ing..."+e.getMessage());
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
