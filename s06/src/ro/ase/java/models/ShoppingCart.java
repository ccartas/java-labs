package ro.ase.java.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Product> products;
	private boolean applyDiscount;
	private double discountPercentage;
	
	public ShoppingCart() {
		products = new ArrayList();
	}
	
}
