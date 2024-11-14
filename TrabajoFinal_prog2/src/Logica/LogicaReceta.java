package Logica;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import data.AccesoDatos;
import model.Ingrediente;
import model.Receta;

public class LogicaReceta {
   
	private AccesoDatos datos;
	private LogicaIngrediente li;
	
	public LogicaReceta() {
		li= new LogicaIngrediente();
		try {	
			File file= new File("Recetas.txt");
	        if(!file.exists()) {
	            file.createNewFile();
	        }
			this.datos=new AccesoDatos(file.getPath());
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.println("error: "+e.getMessage());
		}
	 }
	
	public void guardarReceta(Receta receta) {
		try {
			  List<Receta> listRecetas = this.datos.listObjects();
			  listRecetas.add(receta);
			  this.datos.saveObject(listRecetas);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al guardar Receta..."+e.getMessage());
		}
	}
	
	public Receta buscarReceta(String nombre) {
		try {
			  for(Receta r : (List<Receta>) this.datos.listObjects()) {
				  if(r.getNombre().equals(nombre))
					  return r;
			  }	
			  return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al buscar Receta..."+e.getMessage());
		}
	}
	
	public boolean consumirReceta(String nombre) {
		try {
			  Receta buscarReceta = buscarReceta(nombre);			  
			  Enumeration<Ingrediente> ingredientesKeys= buscarReceta.getIngredientes().keys();
			  while(ingredientesKeys.hasMoreElements()) {				
				  Ingrediente i = ingredientesKeys.nextElement();
				  li.actualizacionStock(i.getNombre(),buscarReceta.getIngredientes().get(i),"quitar");			
			  }
			  return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al consumir Receta..."+e.getMessage());
		}
	}
	
	public void modificarReceta(Receta receta) {
		try {
			 List<Receta> list = this.datos.listObjects();
			 for(Receta r: list) {
				 if(r.getNombre().equals(receta.getNombre())) {
					 list.remove(r);					 
					 break;
				 }
			 }
			 list.add(receta);
			 this.datos.saveObject(list);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al buscar Receta..."+e.getMessage());
		}
	}
	
	public void mostrarRecetas() {
		List<Receta>recetas= this.datos.listObjects();
	    if(!recetas.isEmpty()) {	
			for (Receta receta:recetas) {
					System.out.println(receta.toString());
				}	
	    }else {
	    	System.out.println("No hay recetas");
	    }
	}	   
}
