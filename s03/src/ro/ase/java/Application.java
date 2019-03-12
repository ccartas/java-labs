package ro.ase.java;

public class Application {
	public static void main(String[] args) {
		ProductManager manager = new ProductManager();
		
		//parameter transfer by value
		double mockPrice = 20000;
		manager.computeDiscout(mockPrice);
		System.out.println(mockPrice);
		
		String productName = "Iphone XS";
		manager.changeProductToReseald(productName);
		System.out.println(productName);
		
		//parameter transfer by reference
		double[] prices = {4000, 5000, 3500};
		manager.changeProductPrices(prices);
		for(double price : prices) {
			System.out.println(price);
		}
		
		Product p = new Product();
		p.name = "Iphone";
		manager.changeProduct(p);
		System.out.println(p.name);
		
	}
}
