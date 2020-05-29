package ro.ase.java.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ro.ase.java.models.Coffee;

public class FileUtils {

	public FileUtils() {}
	
	public void saveOrderToTextFile(List<Coffee> orderDetails, String fileName) throws IOException {
		File file = new File(fileName);
		FileWriter writer = new FileWriter(file);
		for(Coffee coffee : orderDetails) {
			writer.write(coffee.getBeverageName() + ","+ coffee.getCoffeeType() + ","+coffee.getPrice()+"\n");
		}
		writer.close();
		System.out.println("Order details were saved in: " + file.getAbsolutePath());
	}
	
	public Map<String, Integer> getOrderFromTextFile(String fileName) throws IOException {
		Map<String, Integer> orderDetails = new HashMap<String, Integer>();
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = "";
		while((line = reader.readLine())!= null) {
			String[] values = line.split(",");
			String beverageName = values[0];
			if(orderDetails.containsKey(beverageName)) {
				orderDetails.put(beverageName, orderDetails.get(beverageName) + 1);
			} else {
				orderDetails.put(beverageName, 1);
			}
		}
		reader.close();
		return orderDetails;
	}
	
	public void writeOrderInBinaryFile(List<Coffee> orderDetails, String fileName) throws IOException {
		File file = new File(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream os = new DataOutputStream(fos);
		os.writeInt(orderDetails.size());
		for(Coffee coffee : orderDetails) {
			os.writeUTF(coffee.getBeverageName());
			os.writeUTF(coffee.getCoffeeType());
			os.writeDouble(coffee.getPrice());
		}
		os.close();
		fos.close();
		System.out.println("Binary file was saved in: " + file.getAbsolutePath());
	}
	
	public void readOrderFromBinaryFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		int noObjects = dis.readInt();
		for(int i = 0; i < noObjects; i++) { 
			System.out.println(dis.readUTF() + ", " + dis.readUTF() + ", " + dis.readDouble());
		}
		dis.close();
		fis.close();
	}
	
	public void serializeOrder(List<Coffee> orderDetails, String fileName) throws IOException {
		File file = new File(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(Coffee c : orderDetails) {
			oos.writeObject(c);
		}
		
		oos.close();
		fos.close();
	}
	
	public void deserializeOrder(String fileName) throws IOException, ClassNotFoundException {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		while(true) {
			try {
				Coffee c = (Coffee) ois.readObject();
				System.out.println(c.getBeverageName() + " " + c.getCoffeeType() + " " + c.getPrice());
			} catch(EOFException ex) {
				break;
			}
		}
		ois.close();
		fis.close();
	}
}
