package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos<E> {

	private String patch;
	
	public AccesoDatos(String patch) {
		this.patch=patch;
	}
	
	public void saveObject(List<E> list) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(this.patch))){
			oos.writeObject(list);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> listObjects(){
		List<E> list = new ArrayList<E>();
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(this.patch))){
			list = (List<E>) ois.readObject();
		}catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception	
			e.printStackTrace();
		}
		return list;
	}
}
