package principal;

import Logica.LogicaCliente;
import Logica.LogicaIngrediente;
import model.Cliente;
import model.Ingrediente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/* LogicaIngrediente li = new LogicaIngrediente();	
		
      Ingrediente i = new Ingrediente();
      i.setCosto(34);
      i.setNombre("Zanaoria");
      i.setStock(34); 
      
      Ingrediente i2 = new Ingrediente();
      i2.setCosto(244);
      i2.setNombre("Papa");
      i2.setStock(50); 
      
      Ingrediente i3 = new Ingrediente();
      i3.setCosto(340);
      i3.setNombre("Zanaoria");
      i3.setStock(24); 
     
      li.guardarIngrediente(i);
      li.guardarIngrediente(i2);
      li.guardarIngrediente(i3);
      
      li.MostrarIngredientes();*/
		
	LogicaCliente lc = new LogicaCliente();
	
	Cliente cli = new Cliente();
	cli.setNombre("Homero Simpson");
	cli.setDireccion("Sprinfield");
	
	Cliente cli2 = new Cliente();
	cli2.setNombre("Bart Simpson");
	cli2.setDireccion("Sprinfield");
	
	Cliente cli3 = new Cliente();
	cli3.setNombre("Lisa Simpson");
	cli3.setDireccion("Sprinfield");
	
	lc.guardarCliente(cli);
	lc.guardarCliente(cli2);
	lc.guardarCliente(cli3);
	
	lc.MostrarClientes();
	}

}
