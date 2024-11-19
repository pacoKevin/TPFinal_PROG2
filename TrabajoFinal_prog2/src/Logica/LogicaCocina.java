package Logica;

import java.io.File;
import java.util.List;

import data.AccesoDatos;
import model.Cliente;
import model.Cocina;

public class LogicaCocina {
private AccesoDatos datos;
	
	public LogicaCocina() {
		try {	
			File file= new File("Cocina.txt");
	        if(!file.exists()) {
	            file.createNewFile();
	        }
			this.datos=new AccesoDatos(file.getPath());
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.println("error: "+e.getMessage());
		}
	}
	
   public boolean guardarSeccion(Cocina cocina) {
	   try {
		   List<Cocina> secciones= this.datos.listObjects();
		   secciones.add(cocina);
		   this.datos.saveObject(secciones);
		   return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al Agregar Seccion: "+e.getMessage());
		return false;
	}
   }
   
   public List<Cocina> listarSecciones(){	
	   List<Cocina> secciones= this.datos.listObjects();  
		  
		   return secciones;	
   }
   
   public void MostrarSecciones() {
	   List<Cocina> secciones= this.datos.listObjects();
		for(Cocina s : secciones) {
			System.out.println(s.toString());		   
		}
			
   }
   
   public boolean limpiarSecciones() {
	   try {
		   List<Cocina> seccion = this.datos.listObjects();
		   seccion.clear();
		   this.datos.saveObject(seccion);
		   return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al Agregar Cliente: "+e.getMessage());
		return false;
	}
   }
   
   // LOGICA MAIN
   
   
   
   
   
   
   
   
   
   
   
}
