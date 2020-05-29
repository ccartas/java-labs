package ro.ase.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ro.ase.java.models.Coffee;
import ro.ase.java.utils.FileUtils;

public class Application {
	public static void main(String[] args) {
		Coffee c1 = new Coffee("Cappuccino", "Costa Rica", 15);
		Coffee c2 = new Coffee("Cappuccino", "Costa Rica", 15);
		Coffee c3 = new Coffee("Cappuccino", "Costa Rica", 15);
		Coffee c4 = new Coffee("Espresso", "Etiopia", 12);
		Coffee c5 = new Coffee("Flat White", "Brasil", 13);
		Coffee c6 = new Coffee("Flat White", "Brasil", 13);
		List<Coffee> order = new ArrayList<Coffee>();
		order.add(c1);
		order.add(c2);
		order.add(c3);
		order.add(c4);
		order.add(c5);
		order.add(c6);
		FileUtils utils = new FileUtils();
		try {
			utils.saveOrderToTextFile(order, "details.txt");
			Map<String, Integer> orderDetails = utils.getOrderFromTextFile("details.txt");
			for(Entry<String, Integer> entry : orderDetails.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			utils.writeOrderInBinaryFile(order, "details.dat");
			System.out.println("-------BINARY READ-----");
			utils.readOrderFromBinaryFile("details.dat");
			utils.serializeOrder(order, "serialize.dat");
			System.out.println("-------DESERIALIZATION-----");
			utils.deserializeOrder("serialize.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
