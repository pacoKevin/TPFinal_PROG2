package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import data.AccesoDatos;
import model.Cocina;
import model.Ingrediente;

public class LogicaIngrediente {

	private Cocina seccionCocina;
	private static LogicaCocina lc = new LogicaCocina();

	public LogicaIngrediente(Cocina seccion) {
		seccionCocina = seccion;
	}
	
   public void guardarIngrediente(Ingrediente ing) {
	   if(seccionCocina.buscarIngrediente(ing.getNombre()) != null) {
		   System.out.println("El ingrediente a añadir ya existe.");
		   return;
	   }
	   seccionCocina.agregarIngrediente(ing);
	   lc.modificarSeccion(seccionCocina);
	   System.out.println("Ingrediente añadido");
   }
   
   public void listarIngredientesDisponibles(){	
	   for (Ingrediente i : seccionCocina.getIngredientes()) {
		   if(i.getStock()>0) {
			   System.out.println(i.toString());
		   }
	   }
   }
   
   public void actualizacionStock(String nombre, int cantidad,String opcion) {
	   try {
		   	Ingrediente ingr = seccionCocina.buscarIngrediente(nombre);
		    if(ingr != null) {
		    	if(opcion.equals("agregar"))
		    		ingr.setStock(ingr.getStock()+cantidad);
		    	if(opcion.equals("quitar"))
		    		ingr.setStock(ingr.getStock()-cantidad);
		    }
	   } catch (Exception e) {
		   throw new RuntimeException("Error al actualizar Stock..."+e.getMessage());
	   }
   }
   
   
   public List<Ingrediente> listarIngredientes(){	
		   return seccionCocina.getIngredientes();
   }
   
   public void mostrarIngredientes() {
		for(Ingrediente l : seccionCocina.getIngredientes()) {
			System.out.println(l.toString());			
		}	
	}
	
}
