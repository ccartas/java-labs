package ro.ase.java.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ro.ase.java.collections.Coffee;

public class FileUtils {

	public FileUtils() {
		
	}
	
	public void saveOrderToTextFile(List<Coffee> order,
			String fileName) throws IOException {
		File f = new File(fileName);
		FileWriter writer = new FileWriter(f);
		for(Coffee c : order) {
			writer.write(c.getBeverageName()+","+c.getCoffeeType()+","+c.getPrice()+"\n");
		}
		writer.close();
		System.out.println("Order saved in "+fileName);
	}
	
	public Map<String, Integer> getOrdersFromTextFile(String fileName)
	 throws IOException{
		Map<String, Integer> orderDetails = new HashMap();
		File f = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line = "";
		while((line=reader.readLine())!=null) {
			String[] values = line.split(",");
			if(orderDetails.containsKey(values[0])) {
				orderDetails.put(values[0], orderDetails.get(values[0])+1);
			} else {
				orderDetails.put(values[0], 1);
			}
		}
		reader.close();
		return orderDetails;
	}
	
	public void writeOrderBinary(List<Coffee> order, String fileName) throws IOException{
		
		FileOutputStream fos = new FileOutputStream(fileName);
		DataOutputStream oos = new DataOutputStream(fos);
		oos.writeInt(order.size());
		for(Coffee c : order) {
			oos.writeUTF(c.getBeverageName());
			oos.writeUTF(c.getCoffeeType());
			oos.writeDouble(c.getPrice());
			
		}
		fos.close();
		oos.close();
	}
	
	public void readOrderBinary(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream ois = new DataInputStream(fis);
		int noObjects = ois.readInt();
		System.out.println(noObjects);
		for(int i = 0; i < noObjects;i++) {
			System.out.println(ois.readUTF());
			System.out.println(ois.readUTF());
			System.out.println(ois.readDouble());
		}
		
		fis.close();
		ois.close();
	}
	
	public void writeOrderSerialize(List<Coffee> order, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(Coffee c : order) {
			oos.writeObject(c);
		}
		
		fos.close();
		oos.close();
	}
	
	public List<Coffee> readOrderDeserialize(String fileName) throws IOException, ClassNotFoundException{
		List<Coffee> order = new ArrayList<Coffee>();
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);	
		while(true) {
			try {
			Coffee c = (Coffee) ois.readObject();
			order.add(c);
			} catch (EOFException ex) {
				break;
			}
		}
		fis.close();
		ois.close();
		return order;
		
	}
}
