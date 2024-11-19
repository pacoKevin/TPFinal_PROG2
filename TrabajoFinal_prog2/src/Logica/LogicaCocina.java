package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import data.AccesoDatos;
import model.Cliente;
import model.Cocina;
import model.Comida;
import model.Pedido;

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
   
   public boolean modificarSeccion(Cocina cocina) {
	   try {
		   List<Cocina> secciones= this.datos.listObjects();
		   List<Cocina> newSecciones = new ArrayList<Cocina>();
		   for (Cocina cocina2 : secciones) {
			   if (cocina2.getEspecialidad().equals(cocina.getEspecialidad())) {
				   newSecciones.add(cocina);
			   } else {
				   newSecciones.add(cocina2);
			   }
		   }
		   this.datos.saveObject(newSecciones);
		   return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al modificar Seccion: "+e.getMessage());
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
		System.out.println("Error al borrar secciones: "+e.getMessage());
		return false;
	}
   }
   
   public boolean guardarSecciones(List<Cocina> secciones) {
	   try {
		   this.datos.saveObject(secciones);
		   return true;
	} catch (Exception e) {
		System.out.println("Error al guardar secciones: "+e.getMessage());
		return false;
	}
   }
   
   public Cocina buscarSeccion(String especialidad) {
	    try {
	        List<Cocina> secciones = this.datos.listObjects();
	        for (Cocina cocina : secciones) {
	            if (cocina.getEspecialidad().equals(especialidad)) return cocina;
	        }
	        return null; // Si no encuentra la sección, retorna null
	    } catch (Exception e) {
	        System.out.println("Error al buscar seccion: " + e.getMessage());
	        return null; // En caso de error, retorna null
	    }
	}
   
   // LOGICA MAIN
   
   public Cocina validarCocina(List<Comida> comidas) {
	    for (Comida comida : comidas) {
	    	Cocina seccion = buscarSeccion(comida.getReceta().getTipo()); 
			if(!seccion.puedeRecibirPedidos()) {
				return seccion; // RETORNA SECCION INVALIDA PARA RECIBIR PEDIDOS
			} 
		}
	    
	    return null; // RETORNA NULL SI LAS SECCIONES SON VALIDAS PARE RECIBIR PEDIDOS
	}
   
   public void repartirPedidosEntreSecciones(Pedido pedido) {
	    for (Comida comida : pedido.getComidas()) {
	    	Cocina seccion = buscarSeccion(comida.getReceta().getTipo());
	    	
	    	Pedido pedidoAux = new Pedido();
			pedidoAux.setCliente(pedido.getCliente());
			pedidoAux.pedidoPendiente();
			pedidoAux.agregarComida(comida);
			seccion.agregarPedido(pedido);
			
			modificarSeccion(seccion);
		}
	}
   
   public void completarPedido(Pedido pedido) {
   	for (Comida comida : pedido.getComidas()) {
	    	Cocina seccion = buscarSeccion(comida.getReceta().getTipo());
	    	
	    	seccion.finalizarPedido();
	    	modificarSeccion(seccion);
		}
	}
   public void cancelarPedido(Pedido pedido) {
   	for (Comida comida : pedido.getComidas()) {
	    	Cocina seccion = buscarSeccion(comida.getReceta().getTipo());
	    	Pedido pedidoCocina = seccion.buscarPedidoPendiente(pedido.getCliente(), comida);
	    	seccion.elminarPedido(pedidoCocina);
	    	modificarSeccion(seccion);
		}
	}
   
   
   
   
   
   
   
   
   
}
