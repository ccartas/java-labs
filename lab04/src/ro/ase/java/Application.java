package ro.ase.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ro.ase.java.models.Product;
import ro.ase.java.models.ShoppingCart;

public class Application {
	public static void main(String[] args) {
		Product p1 = new Product("Hanorac Gucci", "Imbracaminte", 300);
		Product p2 = new Product("Adidasi Nike", "Incaltaminte", 250);
		Product p3 = new Product("Adidasi Nike", "Incaltaminte", 450);
		Product p4 = new Product("Adidasi Nike", "Incaltaminte", 750);
		Product p5 = new Product("Hanorac Gucci", "Imbracaminte", 300);
		ShoppingCart cart = new ShoppingCart();
		cart.addProduct(p1);
		cart.addProduct(p2);
		cart.addProduct(p3);
		cart.addProduct(p4);
		cart.addProduct(p5);
		System.out.println("--------UNORDERED LIST---------");
		for(Product p : cart.getSelectedProducts()) {
			System.out.println(p.getProductName() + " " + p.getCategory() + " " + p.getPrice());
		}
		//Collections.sort(cart.getSelectedProducts());
		cart.getSelectedProducts().sort(null);
		System.out.println("--------SORTED LIST---------");
		for(Product p : cart.getSelectedProducts()) {
			System.out.println(p.getProductName() + " " + p.getCategory() + " " + p.getPrice());
		}
		
		Map<String, Integer> stocks = new HashMap<String, Integer>();
		for(Product p : cart.getSelectedProducts()) {
			if(stocks.containsKey(p.getCategory())) {
				stocks.put(p.getCategory(), stocks.get(p.getCategory()) + 1);
			} else {
				stocks.put(p.getCategory(), 1);
			}
		}
		//
		System.out.println("--------MAP PARSING---------");
		for(Entry<String, Integer> entry : stocks.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		Set<Product> uniqueProducts = new HashSet<Product>();
		uniqueProducts.add(p1);
		uniqueProducts.add(p2);
		uniqueProducts.add(p3);
		uniqueProducts.add(p4);
		uniqueProducts.add(p5);
		uniqueProducts.add(p1);
		System.out.println("--------SET PARSING---------");
		for(Product p : uniqueProducts) {
			System.out.println(p.getProductName() + " " + p.getCategory() + " " + p.getPrice());
		}
		
	}
}
