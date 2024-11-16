package Logica;

import java.io.File;
import java.util.List;

import data.AccesoDatos;
import model.Pedido;

public class LogicaPedido {
      private AccesoDatos datos;
      
      public LogicaPedido() {
    	  try {	
  			File file= new File("Pedidos.txt");
  	        if(!file.exists()) {
  	            file.createNewFile();
  	        }
  			this.datos=new AccesoDatos(file.getPath());
  		 }catch (Exception e) {
  			// TODO: handle exception
  			 System.out.println("error: "+e.getMessage());
  		}
      }
      
   public void generarPedido(Pedido pedido) {
	      try {
			    List<Pedido> list = this.datos.listObjects();
			    list.add(pedido);
			    this.datos.saveObject(list);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al generar pedido..."+e.getMessage());
		}
   }
   
   public Pedido buscarPedido(int dni) {
	   try {
		    List<Pedido> list = this.datos.listObjects();
		    for(Pedido p: list) {
		    	if(p.getCliente().getDni()==dni) {
		    		return p;
		    	}
		    }
		  return null; 
	   }catch(Exception e) {
		   throw new RuntimeException("Error al buscar pedido..."+e.getMessage());
	   }
   } 
   
   public void cancelarPedido(Pedido pedido) {
	   try {
		   List<Pedido> list = this.datos.listObjects();
		    for(Pedido p: list) {
		    	if(p.getCliente().getDni()==pedido.getCliente().getDni()) {
		    		list.remove(p);
		    		break;
		    	}
		    }
		    list.add(pedido);
		    this.datos.saveObject(list);
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException("Error al cancelar Pedido..."+e.getMessage());
	}
   }
   
   public void mostrarPedidos() {
	   try {
		    for(Pedido p:(List<Pedido>) this.datos.listObjects()) {
		    	System.out.println(p.toString());
		    }
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException("Error al mostrar Pedidos..."+e.getMessage());
	}
   }
}
