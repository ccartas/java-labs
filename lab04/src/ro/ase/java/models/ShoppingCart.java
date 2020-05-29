package ro.ase.java.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Product> selectedProducts;
	
	public ShoppingCart() {
		this.selectedProducts = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		this.selectedProducts.add(product);
	}
	
	public List<Product> getSelectedProducts() {
		return this.selectedProducts;
	}
	
}
