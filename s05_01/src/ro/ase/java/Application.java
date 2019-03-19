package ro.ase.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ro.ase.java.collections.Coffee;
import ro.ase.java.io.FileUtils;

public class Application {
	public static void main(String[] args) {
		List<Coffee> order = new ArrayList<>();
		
		Coffee c1 = new Coffee("Cafe Late", "ARABICA", 16.5);
		Coffee c2 = new Coffee("Cappuccinno", "COLUMBIA", 15);
		Coffee c3 = new Coffee("Cappuccinno", "COLUMBIA", 15);
		Coffee c4 = new Coffee("Cappuccinno", "COLUMBIA", 15);
		Coffee c5 = new Coffee("Cappuccinno", "COLUMBIA", 15);
		Coffee c6 = new Coffee("Cappuccinno", "COLUMBIA", 15);
		
		order.add(c1);
		order.add(c2);
		order.add(c3);
		order.add(c4);
		order.add(c5);
		order.add(c6);
		
		try {
			FileUtils utils = new FileUtils();
			utils.saveOrderToTextFile(order, "orders.txt");
			Map<String, Integer> details = utils.getOrdersFromTextFile("orders.txt");
			for(Entry<String, Integer> entry : details.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			utils.writeOrderBinary(order, "orders.dat");
			utils.readOrderBinary("orders.dat");
			
			utils.writeOrderSerialize(order, "serialize.txt");
			
			try {
				System.out.println("Deserializare: ");
				Set<Coffee> unique = new HashSet<>();
				for(Coffee c : utils.readOrderDeserialize("serialize.txt")) {
					System.out.println(c.getBeverageName());
					unique.add(c);
				}
				
				System.out.println("Valorile din set");
				for(Coffee c : unique) {
					System.out.println(c.getBeverageName());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
