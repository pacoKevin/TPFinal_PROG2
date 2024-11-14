package Logica;

import java.io.File;
import java.util.List;

import data.AccesoDatos;
import model.Comida;
import model.Receta;

public class LogicaComida {
      private AccesoDatos datos;
      
      public LogicaComida() {
    	  try {	
  			File file= new File("Comidas.txt");
  	        if(!file.exists()) {
  	            file.createNewFile();
  	        }
  			this.datos=new AccesoDatos(file.getPath());
  		 }catch (Exception e) {
  			// TODO: handle exception
  			 System.out.println("error: "+e.getMessage());
  		}
      }
      
    public void guardarComida(Comida comida) {
    	try {
			  List<Comida> listComidas = this.datos.listObjects();
			  listComidas.add(comida);
			  this.datos.saveObject(listComidas);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al guardar Comida..."+e.getMessage());
		}
    }
    
    public Comida buscarComida(String nombre) {
		try {
			  for(Comida c : (List<Comida>) this.datos.listObjects()) {
				  if(c.getNombre().equals(nombre))
					  return c;
			  }	
			  return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al buscar Receta..."+e.getMessage());
		}
	}
    
    public void mostrarComidas() {
		List<Comida>comidas= this.datos.listObjects();
	    if(!comidas.isEmpty()) {	
			for (Comida comida:comidas) {
					System.out.println(comida.toString());
				}	
	    }else {
	    	System.out.println("No hay Comidas");
	    }
	}	
}
