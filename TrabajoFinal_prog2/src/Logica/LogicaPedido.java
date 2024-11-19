package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import data.AccesoDatos;
import model.Cocina;
import model.Comida;
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
   
   public Pedido buscarPedidoPendiente(int dni) {
	   try {
		    List<Pedido> list = this.datos.listObjects();
		    for(Pedido p: list) {
		    	if(p.getCliente().getDni()==dni && p.getEstado().equals("Pendiente")) {
		    		return p;
		    	}
		    }
		  return null; 
	   }catch(Exception e) {
		   throw new RuntimeException("Error al buscar pedido..."+e.getMessage());
	   }
   }
   
   public Pedido buscarPrimerPedidoPendiente() {
	   try {
		    List<Pedido> list = this.datos.listObjects();
		    for(Pedido p: list) {
		    	if(p.getEstado().equals("Pendiente")) {
		    		return p;
		    	}
		    }
		  return null; 
	   }catch(Exception e) {
		   throw new RuntimeException("Error al buscar pedido..."+e.getMessage());
	   }
   }
   
   public List<Pedido> buscarPedidos(int dni) {
	   try {
		    List<Pedido> list = this.datos.listObjects();
		    List<Pedido> listP = new ArrayList<Pedido>();
		    for(Pedido p: list) {
		    	if(p.getCliente().getDni()==dni && !p.getEstado().equals("Completado")) {
		    		listP.add(p);
		    	}
		    }
		  return listP; 
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
   
   public void mostrarPedidosSimplificado() {
	   try {
		    for(Pedido p:(List<Pedido>) this.datos.listObjects()) {
		    	String comidas = "";
		    	for (Comida com : p.getComidas()) {
					comidas = comidas.concat(com.getNombre() + ", ");
				}
		    	System.out.println("Cliente: " + p.getCliente() + " || Comidas: " + comidas +" || Estado: "+ p.getEstado() );
		    }
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException("Error al mostrar Pedidos..."+e.getMessage());
	}
   }
   
   public boolean limpiarPedidos() {
	   try {
		   List<Pedido> pedidos= this.datos.listObjects();
		   pedidos.clear();
		   this.datos.saveObject(pedidos);
		   return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al eliminar pedidos: "+e.getMessage());
		return false;
	}
   }
   
   public boolean modificarPedidos(Pedido pedido) {
	   try {
		   List<Pedido> pedidos= this.datos.listObjects();
		   List<Pedido> newPedidos = new ArrayList<Pedido>();
		   for (Pedido pedido2 : pedidos) {
			   if (pedido2.getCliente().getDni() == (pedido.getCliente().getDni())) {
				   newPedidos.add(pedido);
				   System.out.println("ENTROO");
			   } else {
				   newPedidos.add(pedido2);
			   }
		   }
		   this.datos.saveObject(newPedidos);
		   return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al modificar Seccion: "+e.getMessage());
		return false;
	}
   }

}
