package ro.ase.java;

public class ProductManager {
	
	public void computeDiscout(double price) {
		price = price - (price * 0.2);
	}
	
	public void changeProductToReseald(String productName) {
		productName = "[RESEALED]"+productName;
	}
	
	public void changeProductPrices(double[] prices) {
		for(int i = 0; i < prices.length; i++) {
			prices[i] = prices[i] + (prices[i] * 0.1);
		}
	}
}
