package principal;

import java.util.ArrayList; 
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import Logica.LogicaIngrediente;
import Logica.LogicaReceta;
import model.Ingrediente;
import model.Receta;

public class MainReceta {
	
	private static LogicaIngrediente li=new LogicaIngrediente();
	private static LogicaReceta lr= new LogicaReceta();

	public static void Principal() {
		int op =0;
		do{
	    	 System.out.println("""
	    	 		1) Agregar Nueva Receta.
	    	 		2) Modificar Receta.
	    	 		3) Mostrar Recetas.
	    	 		0) Salir
	    	 		""");
	    	 op = Helper.getInteger("Ingrese Opcion: ");
	    	 switch (op) {
					case 1: {
						       lr.guardarReceta(completarDatos("nuevo"));
					        break;}
					case 2: { lr.mostrarRecetas();
						      String nombreReceta= Helper.getString("Ingrese Nombre de la receta: ");
						      Receta buscarReceta= lr.buscarReceta(nombreReceta);
						      if(buscarReceta!=null) 
						    	  modificarReceta(buscarReceta);
						      else 
						    	 System.out.println("La receta no existe...");
				            break;}	
					case 3: { 
						     lr.mostrarRecetas();						       
				            break;}	
					case 0: {break;}
					default:
						throw new IllegalArgumentException("Error en menu cliente...");
					}
	    	}while(op!=0);
	}
	
	private static Receta completarDatos(String op) {
		Receta rec = new Receta();
		if(op.equals("nuevo")) {
			rec.setNombre(validarNombre());
		}		      
		rec.setTipo(validarTipoReceta());
		rec.setModoPreparacion(Helper.getString("Ingrese modo de preparacion: "));
		rec.setTiempoCoccion(Helper.getInteger("Ingrese tiempo de cocción: "));
		rec.setComplejidad(ingresarComplejidad());
		rec.setIngredientes(ingresarIngredientes());
		rec.setRecetas(ingresarReceta());		
		return rec;		
	}
	
	private static String validarTipoReceta() {
	   int op=0;
	   do {
			System.out.println("""
					****TIPOS****
					1) horno.
					2) gurmet.
					3) ensalada.
					4) postre.				
					""");
			op=Helper.getInteger("Ingrese Opcion: ");
			switch (op) {
				case 1: { return "horno";}
				case 2: { return "gurmet";}
				case 3: { return "ensalada";}
				case 4: { return "postre";}
				default:{ op=239;
				System.out.println("Opcion Incorrecta...");}
				}
	   }while(op!=0);
       return "";
	}
	
	private static String validarNombre() {
		boolean band=true;
		do {
			String nombre = Helper.getString("Ingrese Nombre: ");
			if(lr.buscarReceta(nombre)==null) {
				return nombre;
			}else {
				System.out.println("Una receta con el mismo nombre ya existe!!");
			}
		}while(band);	
		return null;
	}
	
	private static int ingresarComplejidad() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				int integerValue;
				 do {
					  System.out.print("Ingrese Complejidad 1,2,3: ");
					  integerValue = Integer.parseInt(scanner.nextLine());
				 }while(integerValue!=1 && integerValue!=2 && integerValue!=3 );				 
	             return integerValue;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ingrese numero valido");
			}
		}
	}
	
	private static Dictionary<Ingrediente,Integer> ingresarIngredientes(){
		Dictionary<Ingrediente,Integer> dicIngredientes=new Hashtable<Ingrediente,Integer>();
		li.MostrarIngredientes();
		char op='n';
		do {
			String nombreIngrediente= Helper.getString("Ingrese Ingrediente: ");
			Ingrediente ing = li.buscarIngrediente(nombreIngrediente);
			if(ing!=null) {
				int cantidad = Helper.getInteger("Ingrese cantidad: ");
				dicIngredientes.put(ing,cantidad);
			}else
				System.out.println("Ingrediente no existe...");
			op=Helper.getCharacter("Desea Seguir s/n: ");						
		}while(op!='n');
		return dicIngredientes;
	}
	
    private static List<Receta> ingresarReceta(){
	  lr.mostrarRecetas();
	  List<Receta> list = new ArrayList<Receta>();
	  char op='n';
	  do {
		  String nombreReceta= Helper.getString("Ingrese Receta: ");
			Receta rec = lr.buscarReceta(nombreReceta);
			if(rec!=null) {
				list.add(rec);
			}else
				System.out.println("Receta no existe...");
			op=Helper.getCharacter("Desea seguir s/n: ");
	  }while(op!='n');
	  
	  return list;
  }

    private static void modificarReceta(Receta receta) {
     	  System.out.println(receta.toString());
     	  Receta recetaModificada = completarDatos("modificar");
     	  recetaModificada.setNombre(receta.getNombre());
     	  lr.modificarReceta(recetaModificada);
    } 

}
