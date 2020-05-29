package ro.ase.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ro.ase.java.models.Product;

public class Application {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product("Asus ROG", "LAPTOP", 5000));
		products.add(new Product("Asus Zenbook", "LAPTOP", 7000));
		products.add(new Product("Asus Zenphone", "SMARTPHONE", 3000));
		products.add(new Product("Galaxy Fold", "SMARTPHONE", 10000));
		products.add(new Product("Samsung Galaxy S20", "SMARTPHONE", 4500));
		
		List<Product> filteredProducts = new ArrayList<Product>();
		for(Product p : products) {
			if(p.getCategory().equals("LAPTOP")) {
				filteredProducts.add(p);
			}
		}
		
		for(Product p : filteredProducts) {
			System.out.println(p.getProductName() + " " + p.getCategory());
		}
		
		
		List<Double> filteredProductPrices = new ArrayList<Double>();
		for(Product p : filteredProducts) {
			filteredProductPrices.add(p.getPrice());
		}
		
		for(double price : filteredProductPrices) {
			System.out.println(price);
		}
		
		List<Double> filteredStreamList = products.stream().filter(product -> product.getCategory().equals("LAPTOP"))
						 .map(product -> product.getPrice())
						 .collect(Collectors.toList());
						/* .stream()
						 .forEach(price -> {
							 System.out.println(price);
						 });*/
		for(Double price : filteredStreamList) {
			System.out.println("Price: " + price);
		}
		
	}
}
